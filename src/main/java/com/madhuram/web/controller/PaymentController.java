package com.madhuram.web.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.madhuram.web.dao.CartDao;
import com.madhuram.web.dao.CategoryDao;
import com.madhuram.web.dao.ItemsDao;
import com.madhuram.web.dao.OrdersDao;
import com.madhuram.web.dao.ParameterDao;
import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.Cart;
import com.madhuram.web.entities.Items;
import com.madhuram.web.entities.Orders;
import com.madhuram.web.entities.Parameters;
import com.madhuram.web.entities.PaytmDetailPojo;
import com.madhuram.web.entities.Users;
import com.madhuram.web.services.SecurityService;
import com.paytm.pg.merchant.PaytmChecksum;

@Controller
@RequestMapping("/user/payment")
public class PaymentController {
	
	@Autowired
	private PaytmDetailPojo paytmDetailPojo;
	@Autowired
	private SecurityService securityService;
	@Autowired
	UserDao userDao;
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	ItemsDao itemsDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ParameterDao parameterDao;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("username", securityService.findLoggedInUsername());
	    model.addAttribute("userid", userDao.get(securityService.findLoggedInUsername()).getUserID());
	}
	
	 @RequestMapping(value = "/submitPaymentDetail")
	    public String getRedirect(Model m) throws Exception {
		 	Users user = userDao.get(securityService.findLoggedInUsername());
		 	Orders o = new Orders();
		 	o.setOrderDate(LocalDate.now());
		 	o.setOrderTime(LocalTime.now());
		 	Double qty = Double.valueOf(0.0);
		 	List<Cart> items = cartDao.getItemList(user.getUserID());
		 	for(Cart item: items) {
		 		qty += item.getQty();
		 	}
		 	o.setTotalQty(qty);
			Double total = Double.valueOf(0.0);
			for(Cart item: items) {
				Double quantity = item.getQty();
				Integer ItemID = item.getItemID();
				Items j = itemsDao.get(ItemID);
				Double unitCost = j.getItemCost();
				total += unitCost * quantity;
			}
			o.setAmount(total);
			List<Parameters> param = parameterDao.getAll();
			for(Parameters p: param) {
				if(p.getParameter().equals("Delivery Charge")) {
					o.setDeliveryCharge(p.getValue());
				}
				if(p.getParameter().equals("GST Percent")) {
					o.setGST(p.getValue());
				}
			}
			total = total * (1 + o.getGST()/100) + o.getDeliveryCharge();
			o.setTotalAmount(total);
			o.setUserID(user.getUserID());
			o.setStatus("Processing");
			ordersDao.save(o);
	        String token = createTxnToken(user, ordersDao.get(user.getUserID(), o.getOrderDate(), o.getOrderTime()), total);
	        o = ordersDao.get(user.getUserID(), o.getOrderDate(), o.getOrderTime());
	        m.addAttribute("orderId", o.getOrderID());
	        m.addAttribute("txnToken", token);
	        m.addAttribute("mid", paytmDetailPojo.getMerchantId());
	        m.addAttribute("url", paytmDetailPojo.getPaytmUrl());
	        return "user/processTxn";
	    }
	 
	private String createTxnToken(Users user, Orders o, Double amount) throws Exception {
		JSONObject paytmParams = new JSONObject();
		
		JSONObject body = new JSONObject();
		body.put("requestType", "Payment");
		body.put("mid", paytmDetailPojo.getMerchantId());
		body.put("websiteName", "WEBSTAGING");
		body.put("orderId", o.getOrderID().toString());
		body.put("callbackUrl", paytmDetailPojo.getCallbackUrl());

		JSONObject txnAmount = new JSONObject();
		txnAmount.put("value", String.format("%.2f", amount).toString());
		txnAmount.put("currency", "INR");

		JSONObject userInfo = new JSONObject();
		userInfo.put("custId", user.getUserID().toString());
		body.put("txnAmount", txnAmount);
		body.put("userInfo", userInfo);
		/*
		* Generate checksum by parameters we have in body
		* You can get Checksum JAR from https://developer.paytm.com/docs/checksum/
		* Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
		*/

		String checksum = PaytmChecksum.generateSignature(body.toString(), paytmDetailPojo.getMerchantKey());
		
		JSONObject head = new JSONObject();
		head.put("signature", checksum);

		paytmParams.put("body", body);
		paytmParams.put("head", head);

		String post_data = paytmParams.toString();
		/* for Staging */
		URL url = new URL("https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid=" + paytmDetailPojo.getMerchantId() + "&orderId=" + o.getOrderID());

		/* for Production */
		// URL url = new URL("https://securegw.paytm.in/theia/api/v1/initiateTransaction?mid=YOUR_MID_HERE&orderId=ORDERID_98765");

		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
			requestWriter.writeBytes(post_data);
			requestWriter.close();
			String responseData = "";
			InputStream is = connection.getInputStream();
			BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
			if ((responseData = responseReader.readLine()) != null) {
				
				Map<String, Object> retMap = new Gson().fromJson(
				    responseData, new TypeToken<HashMap<String, Object>>() {}.getType()
				);
				Map<String, Object> bodyMap = (Map<String, Object>) retMap.get("body");
				return bodyMap.get("txnToken").toString();
			}
			responseReader.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}