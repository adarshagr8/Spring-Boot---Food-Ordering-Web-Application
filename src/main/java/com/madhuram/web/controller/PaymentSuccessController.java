package com.madhuram.web.controller;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.madhuram.web.dao.CartDao;
import com.madhuram.web.dao.CategoryDao;
import com.madhuram.web.dao.ItemsDao;
import com.madhuram.web.dao.OrderedItemsDao;
import com.madhuram.web.dao.OrdersDao;
import com.madhuram.web.dao.TransactionDao;
import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.Cart;
import com.madhuram.web.entities.CartItem;
import com.madhuram.web.entities.Items;
import com.madhuram.web.entities.OrderedItems;
import com.madhuram.web.entities.Orders;
import com.madhuram.web.entities.Transactions;
import com.madhuram.web.entities.Users;
import com.madhuram.web.services.SecurityService;

@Controller
public class PaymentSuccessController {
	
	private static final int BUFFER_SIZE = 4096;
	
	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ItemsDao itemDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	OrderedItemsDao orderedItemsDao;
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private String invoice(Users u, Orders o, List<OrderedItems> l) throws JSONException, IOException {
		URL url = new URL("https://invoice-generator.com");
		JSONObject data = new JSONObject();
		data.put("logo", "https://i.ibb.co/rHQmSgX/madhuram-sweets.png");
		data.put("from", "Madhuram Sweets,\nNear Bus Stand, Mandla, \nMadhya Pradesh Pin - 481661");
		data.put("to", u.getName() + '\n' + "Email: " + u.getEmailAddress() + "\n" + "Phone: " + u.getPhoneNumber());
		data.put("ship_to", u.getHouseNo() + "\n" + u.getLocality() + "\n" + u.getStreet());
		data.put("number", o.getOrderID());
		data.put("currency", "INR");
		data.put("date", o.getOrderDate().toString());
		data.put("tax", o.getGST());
		data.put("shipping", o.getDeliveryCharge());
		data.put("amount_paid", o.getTotalAmount());
		data.put("notes", "Thanks for purchasing at Madhuram. We hope you will visit again soon!!");
		JSONArray a = new JSONArray();
		for(OrderedItems item: l) {
			JSONObject itemc = new JSONObject();
			itemc.put("quantity", item.getQty());
			Items i = itemDao.get(item.getItemID());
			itemc.put("unit_cost", i.getItemCost());
			itemc.put("name", i.getItemName());
			a.put(itemc);
		}
		data.put("items", a);
		String post_data = data.toString();
		System.out.print(post_data);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
		requestWriter.writeBytes(post_data);
		requestWriter.close();
		InputStream inputStream = connection.getInputStream();
		String saveFilePath = System.getProperty("user.dir") + "/src/main/resources/invoice/" + "INVOICE_ID_" + o.getOrderID() + ".pdf";
		FileOutputStream outputStream = new FileOutputStream(saveFilePath);
		System.out.println(saveFilePath);
        int bytesRead = -1;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        inputStream.close();
		return saveFilePath;
	}
	
	@RequestMapping(value = "/pgresponse", method=RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public RedirectView response(@RequestBody MultiValueMap<String, String> formData, RedirectAttributes attributes, Model m) {
		attributes.addFlashAttribute("data", formData);
		String status = formData.getFirst("STATUS");
		if(status.equals("TXN_SUCCESS")) {
			return new RedirectView("/pgresponse/success");
		}
		else {
			return new RedirectView("/pgresponse/failed");
		}
	}
	@RequestMapping(value = "/pgresponse/success")
	public String sucesss(@ModelAttribute("data") Object flashAttribute, Model m) throws JSONException, IOException {
		@SuppressWarnings("unchecked")
		MultiValueMap<String, String> formData = (MultiValueMap<String, String>) flashAttribute;
		Integer orderId = Integer.parseInt(formData.getFirst("ORDERID"));
		Orders o = ordersDao.get(orderId);
		Integer userId = o.getUserID();
		Users user = userDao.get(userId);
		String txnId = formData.getFirst("TXNID");
		String banktId = formData.getFirst("BANKTXNID");
		Double amount = Double.parseDouble(formData.getFirst("TXNAMOUNT"));
		String status = formData.getFirst("STATUS");
		String method = formData.getFirst("PAYMENTMODE");
		ordersDao.updateStatus(orderId, "SUCCESS");
		Transactions t = new Transactions();
		t.setTransactionID(formData.getFirst("TXNID"));
		t.setBankTransactionID(formData.getFirst("BANKTXNID"));
		t.setInvoiceAmount(Double.parseDouble(formData.getFirst("TXNAMOUNT")));
		t.setStatus(status);
		t.setUserID(userId);
		t.setTransactionTime(LocalDateTime.now());
		t.setPaymentMethod(formData.getFirst("PAYMENTMODE"));
		List<Cart> l = cartDao.getItemList(userId);
		cartDao.clearCart(userId);
		List<OrderedItems> il = new LinkedList();
		List<CartItem> cl = new LinkedList();
		for(Cart c: l) {
			OrderedItems i = new OrderedItems();
			i.setItemID(c.getItemID());
			i.setOrderID(orderId);
			i.setQty(c.getQty());
			orderedItemsDao.save(i);
			il.add(i);
			Double quantity = c.getQty();
			Integer ItemID = c.getItemID();
			Items j = itemDao.get(ItemID);
			String itemName = j.getItemName();
			Integer categoryID = j.getCategoryID();
			String categoryName = categoryDao.get(categoryID).getCategoryName();
			Double unitCost = j.getItemCost();
			CartItem cp = new CartItem(itemName, quantity, categoryName, unitCost, ItemID);
			cl.add(cp);
		}
		String invoicePath = invoice(user, o, il);
		t.setInvoice(invoicePath);
		transactionDao.save(t);
		ordersDao.updateTxn(orderId, t.getTransactionID());
		m.addAttribute("order", o);
		m.addAttribute("items", cl);
		m.addAttribute("txn", t);
		return "/txnsuccess";
	}
	
	@RequestMapping("/pgresponse/failed")
	public String failed(@ModelAttribute("data") Object flashAttribute, Model m) {
		@SuppressWarnings("unchecked")
		MultiValueMap<String, String> formData = (MultiValueMap<String, String>) flashAttribute;
		Integer orderId = Integer.parseInt(formData.getFirst("ORDERID"));
		Orders o = ordersDao.get(orderId);
		Integer userId = o.getUserID();
		Users user = userDao.get(userId);
		String txnId = formData.getFirst("TXNID");
		String banktId = formData.getFirst("BANKTXNID");
		Double amount = Double.parseDouble(formData.getFirst("TXNAMOUNT"));
		String status = formData.getFirst("STATUS");
		String method = formData.getFirst("PAYMENTMODE");
		String message = formData.getFirst("RESPMSG");
		ordersDao.updateStatus(orderId, "FAILED");
		o.setStatus("Failed");
		Transactions t = new Transactions();
		t.setTransactionID(formData.getFirst("TXNID"));
		t.setBankTransactionID(formData.getFirst("BANKTXNID"));
		t.setInvoiceAmount(Double.parseDouble(formData.getFirst("TXNAMOUNT")));
		t.setStatus(status);
		t.setUserID(userId);
		t.setTransactionTime(LocalDateTime.now());
		t.setPaymentMethod(formData.getFirst("PAYMENTMODE"));
		transactionDao.save(t);
		ordersDao.updateTxn(orderId, t.getTransactionID());
		m.addAttribute("order", o);
		m.addAttribute("txn", t);
		m.addAttribute("message", message);
		return "/txnfailed";
	}
	
	@ResponseBody
	@RequestMapping(
		value = "/downloadinvoice",
		produces = MediaType.APPLICATION_OCTET_STREAM_VALUE,
		method = RequestMethod.POST
	)
	private FileSystemResource download(@RequestBody MultiValueMap<String, String> formData, Model m) throws IOException {
		String tid = formData.getFirst("tid");
		System.out.println(tid);
		Transactions t = transactionDao.get(tid);
		String filepath = t.getInvoice();
		return new FileSystemResource(filepath); 
	}
}
