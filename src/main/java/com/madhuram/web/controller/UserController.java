package com.madhuram.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.madhuram.web.dao.CartDao;
import com.madhuram.web.dao.CategoryDao;
import com.madhuram.web.dao.ItemsDao;
import com.madhuram.web.dao.OrdersDao;
import com.madhuram.web.dao.ParameterDao;
import com.madhuram.web.dao.TransactionDao;
import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.Cart;
import com.madhuram.web.entities.CartItem;
import com.madhuram.web.entities.Categories;
import com.madhuram.web.entities.Items;
import com.madhuram.web.entities.Parameters;
import com.madhuram.web.entities.PaytmDetailPojo;
import com.madhuram.web.entities.Transactions;
import com.madhuram.web.entities.Users;
import com.madhuram.web.services.SecurityService;
import com.madhuram.web.services.SecurityServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	SecurityServiceImpl auth;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ItemsDao itemsDao;
	
	@Autowired
	ParameterDao parameterDao;
	
	@Autowired
	PaytmDetailPojo paytmDetailPojo;
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	private SecurityService securityService;
	
	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("username", securityService.findLoggedInUsername());
	    model.addAttribute("userid", userDao.get(securityService.findLoggedInUsername()).getUserID());
	}
	
	@RequestMapping("/orderportal")
	private String portal(Model m) {
		return "user/orderportal";
	}
	
	@RequestMapping("/userdetails")
	public String userDetails(Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		m.addAttribute("user", user);
		return "user/userdetails";
	}
	
	@RequestMapping("/items")
	private String items(Model m) {
		List<Categories> c = categoryDao.getAll();
		m.addAttribute("categories", c);
		return "user/categories";
	}
	
	@RequestMapping("/items/{categoryid}")
	private String items(@PathVariable("categoryid") Integer id, Model m) {
		List<Items> items = itemsDao.getOfCategory(id);
		Categories c = categoryDao.get(id);
		m.addAttribute("items", items);
		m.addAttribute("category", c);
		return "user/items";
	}
	@RequestMapping("/items/{categoryid}/{itemid}")
	private String items(@PathVariable("categoryid") Integer cid, @PathVariable("itemid") Integer iid, Model m) {
		Items item = itemsDao.get(iid);
		m.addAttribute("item", item);
		return "user/showitem";
	}
	
	@RequestMapping("/additem")
	private String addItem(@ModelAttribute Cart cart, Model m) {
		cartDao.save(cart);
		Items item = itemsDao.get(cart.getItemID());
		String ret = "/user/items/" + Integer.toString(item.getCategoryID());
		return "redirect:" + ret;
	}
	
	@RequestMapping("/cart")
	private String showCart(Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		List<Cart> items = cartDao.getItemList(user.getUserID());
		List<CartItem> ret = new LinkedList<CartItem>();
		Double total = Double.valueOf(0.0);
		for(Cart item: items) {
			Double quantity = item.getQty();
			Integer ItemID = item.getItemID();
			Items j = itemsDao.get(ItemID);
			String itemName = j.getItemName();
			Integer categoryID = j.getCategoryID();
			String categoryName = categoryDao.get(categoryID).getCategoryName();
			Double unitCost = j.getItemCost();
			total += unitCost * quantity;
			CartItem c = new CartItem(itemName, quantity, categoryName, unitCost, ItemID);
			ret.add(c);
		}
		m.addAttribute("itemtotal", total);
		List<Parameters> param = parameterDao.getAll();
		for(Parameters p: param) {
			if(p.getParameter().equals("Delivery Charge")) {
				m.addAttribute("delivery", p.getValue());
			}
			if(p.getParameter().equals("GST Percent")) {
				m.addAttribute("gst", p.getValue());
			}
		}
		System.out.println(total);
		m.addAttribute("total", total*(1 + (Double) m.getAttribute("gst") / 100) + (Double)m.getAttribute("delivery"));
		m.addAttribute("cart", ret);
		return "user/cart";
	}
	
	@RequestMapping("/delete/{itemid}")
	private String delete(@PathVariable("itemid") Integer id, Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		cartDao.delete(user.getUserID(), id);
		return "redirect:/user/cart";
	}
}
