package com.madhuram.web.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.madhuram.web.dao.CartDao;
import com.madhuram.web.dao.CategoryDao;
import com.madhuram.web.dao.ComplaintsDao;
import com.madhuram.web.dao.FeedbacksDao;
import com.madhuram.web.dao.ItemsDao;
import com.madhuram.web.dao.OrderedItemsDao;
import com.madhuram.web.dao.OrdersDao;
import com.madhuram.web.dao.ParameterDao;
import com.madhuram.web.dao.TransactionDao;
import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.Cart;
import com.madhuram.web.entities.CartItem;
import com.madhuram.web.entities.Categories;
import com.madhuram.web.entities.Complaints;
import com.madhuram.web.entities.Feedbacks;
import com.madhuram.web.entities.Items;
import com.madhuram.web.entities.OrderedItems;
import com.madhuram.web.entities.Orders;
import com.madhuram.web.entities.Parameters;
import com.madhuram.web.entities.PaytmDetailPojo;
import com.madhuram.web.entities.Transactions;
import com.madhuram.web.entities.Users;
import com.madhuram.web.services.SecurityService;
import com.madhuram.web.services.SecurityServiceImpl;
import com.madhuram.web.services.StorageService;

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
	OrderedItemsDao orderedItemsDao;
	
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
	ComplaintsDao complaintsDao;
	
	@Autowired
	FeedbacksDao feedbacksDao;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	StorageService storageService;
	
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
	@RequestMapping("/edit")
	public String edit(Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		m.addAttribute("u", user);
		return "user/editdetails";
	}
	
	@RequestMapping("/editdone")
	public String edit(@ModelAttribute Users user, Model m) {
		System.out.println(user);
		userDao.updateUser(user);
		return "redirect:/user/userdetails";
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
		List<Items> ret = new LinkedList();
		for(Items i: items) {
			if(i.getEnabled() == 1) ret.add(i);
		}
		Categories c = categoryDao.get(id);
		m.addAttribute("items", ret);
		m.addAttribute("category", c);
		System.out.println(items);
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
	
	@RequestMapping("/orders")
	private String listOrders(Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		List<Orders> l = ordersDao.getForUser(user.getUserID());
		Collections.reverse(l);
		m.addAttribute("orders", l);
		return "/user/orders";
	}
	
	@RequestMapping("/orders/{orderid}")
	private String viewOrder(@PathVariable("orderid") Integer id, Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		Orders o = ordersDao.get(id);
		Transactions t = transactionDao.get(o.getTransactionID());
		m.addAttribute("order", o);
		List<OrderedItems> items = orderedItemsDao.getOrder(o.getOrderID());
		
		List<CartItem> l = new LinkedList();
		for(OrderedItems item: items) {
			Double quantity = item.getQty();
			Integer ItemID = item.getItemID();
			Items j = itemsDao.get(ItemID);
			Double unitCost = j.getItemCost();
			Categories cat = categoryDao.get(j.getCategoryID());
			CartItem c = new CartItem(j.getItemName(), quantity, cat.getCategoryName(), unitCost, ItemID);
			l.add(c);
		}
		if(o.getUserID() == user.getUserID()) {
			m.addAttribute("txn", t);
			m.addAttribute("user", user);
			m.addAttribute("items", l);
			return "/user/showorder";
		}
		return "error";
	}
	
	@RequestMapping("/complaint")
	private String complaint(Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		List<Complaints> l = complaintsDao.getAllOfUser(user.getUserID());
		m.addAttribute("comp", l);
		return "user/complaint";
	}
	
	@RequestMapping("/complaint/{cid}")
	private String complaint(@PathVariable("cid") Integer cid, Model m) {
		Complaints c = complaintsDao.get(cid);
		Users user = userDao.get(securityService.findLoggedInUsername());
		if(c.getUserID() == user.getUserID()) {
			m.addAttribute("c", c);
			System.out.println(c);
			return "user/showcomplaint";
		}
		return "error";
	}
	@RequestMapping("/complaint/newcomplaint")
	private String newComplaint(Model m) {
		return "user/complaintform";
	}
	
	@RequestMapping("/complaint/process")
	private String newComplaint(@ModelAttribute Complaints comp, @RequestParam("photo") MultipartFile file, Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		comp.setRecordedTime(java.time.LocalDateTime.now());
		comp.setUserID(user.getUserID());
		comp.setStatus("UNDER REVIEW");
		if(!file.getOriginalFilename().isEmpty()) {
			storageService.save(file);
			Path p = Paths.get("uploads");
			Path q = p.resolve(file.getOriginalFilename());
			String s = q.toString();
			s = "/images/" + s;
			comp.setImage(s);
		}
		complaintsDao.save(comp);
		return "redirect:/user/complaint";
	}
	
	@RequestMapping("/feedback")
	private String feedback(Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		List<Feedbacks> l = feedbacksDao.getAllOfUser(user.getUserID());
		m.addAttribute("comp", l);
		return "user/feedback";
	}
	
	@RequestMapping("/feedback/{cid}")
	private String feedback(@PathVariable("cid") Integer cid, Model m) {
		Feedbacks c = feedbacksDao.get(cid);
		Users user = userDao.get(securityService.findLoggedInUsername());
		if(c.getUserID() == user.getUserID()) {
			m.addAttribute("c", c);
			System.out.println(c);
			return "user/showfeedback";
		}
		return "error";
	}
	@RequestMapping("/feedback/newfeedback")
	private String newFeedback(Model m) {
		return "user/feedbackform";
	}
	
	@RequestMapping("/feedback/process")
	private String newFeedback(@ModelAttribute Feedbacks comp, Model m) {
		Users user = userDao.get(securityService.findLoggedInUsername());
		comp.setRecordedTime(java.time.LocalDateTime.now());
		comp.setUserID(user.getUserID());
		comp.setStatus(0);
		feedbacksDao.save(comp);
		return "redirect:/user/feedback";
	}
}
