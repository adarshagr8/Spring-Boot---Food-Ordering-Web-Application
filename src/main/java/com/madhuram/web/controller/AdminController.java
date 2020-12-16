package com.madhuram.web.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
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
import org.springframework.web.servlet.ModelAndView;

import com.madhuram.web.dao.CategoryDao;
import com.madhuram.web.dao.ComplaintsDao;
import com.madhuram.web.dao.FAQDao;
import com.madhuram.web.dao.FeedbacksDao;
import com.madhuram.web.dao.GalleryDao;
import com.madhuram.web.dao.ItemsDao;
import com.madhuram.web.dao.OrderedItemsDao;
import com.madhuram.web.dao.OrdersDao;
import com.madhuram.web.dao.ParameterDao;
import com.madhuram.web.dao.TransactionDao;
import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.CartItem;
import com.madhuram.web.entities.Categories;
import com.madhuram.web.entities.Complaints;
import com.madhuram.web.entities.FAQ;
import com.madhuram.web.entities.Feedbacks;
import com.madhuram.web.entities.Gallery;
import com.madhuram.web.entities.Items;
import com.madhuram.web.entities.OrderedItems;
import com.madhuram.web.entities.Orders;
import com.madhuram.web.entities.Parameters;
import com.madhuram.web.entities.Transactions;
import com.madhuram.web.entities.Users;
import com.madhuram.web.services.SecurityService;
import com.madhuram.web.services.SecurityServiceImpl;
import com.madhuram.web.services.StorageService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	SecurityServiceImpl auth;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	ItemsDao itemsDao;
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	OrderedItemsDao orderedItemsDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	FAQDao faqDao;
	
	@Autowired
	GalleryDao galleryDao;
	
	@Autowired
	FeedbacksDao feedbacksDao;
	
	@Autowired
	ComplaintsDao complaintsDao;
	
	@Autowired
	ParameterDao parameterDao;
	
	@RequestMapping("")
	public ModelAndView main() {
		ModelAndView m = new ModelAndView("admin/admin");
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
	@RequestMapping("/users")
	public ModelAndView listUsers() {
		ModelAndView m = new ModelAndView("admin/users");
		List<Users> users = userDao.getAll();
		List<Users> ret = new LinkedList<>();
		for(Users user: users) {
			if(user.getAuthority().equals("ROLE_user")) ret.add(user);
		}
		m.addObject("role", "users");
		m.addObject("users", ret);
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
	@RequestMapping("/users/{userid}")
	public ModelAndView showuser(@PathVariable("userid") Integer id) {
		ModelAndView m = new ModelAndView("admin/showuser");
		Users user = userDao.get(id);
		m.addObject("user", user);
		if(user.getAuthority().equals("ROLE_user")) {
			m.addObject("role", "User");
		}
		if(user.getAuthority().equals("ROLE_admin")) {
			m.addObject("role", "Admin");
		}
		return m;
	}	
	
	@RequestMapping("/users/deleteuser/{userid}")
	public String deleteuser(@PathVariable("userid") Integer id) {
		userDao.delete(id);
		return "redirect:/admin/users";
	}
	
	@RequestMapping("/users/edit/{userid}")
	public String edituser(@PathVariable("userid") Integer id, Model m) {
		Users user = userDao.get(id);
		m.addAttribute("u", user);
		
		return "admin/userform";
	}
	
	@RequestMapping("/editdone")
	public String edituser(@ModelAttribute Users user, Model m) {
		userDao.update(user);
		return "admin/admin";
	}
	
	@RequestMapping("/admins")
	public ModelAndView listAdmins() {
		ModelAndView m = new ModelAndView("admin/users");
		List<Users> users = userDao.getAll();
		List<Users> ret = new LinkedList<>();
		for(Users user: users) {
			if(user.getAuthority().equals("ROLE_admin")) ret.add(user);
		}
		m.addObject("role", "admins");
		m.addObject("users", ret);
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
	@RequestMapping("/orders")
	public ModelAndView listOrders() {
		ModelAndView m = new ModelAndView("admin/orders");
		List<Orders> orders = ordersDao.getAll();
		Collections.reverse(orders); 
		m.addObject("orders", orders);
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
	
	@RequestMapping("/orders/{orderid}")
	public ModelAndView showOrder(@PathVariable("orderid") Integer id) {
		ModelAndView m = new ModelAndView("admin/showorder");
		Orders o = ordersDao.get(id);
		m.addObject("order", o);
		String tid = o.getTransactionID();
		Transactions txn = transactionDao.get(tid);
		m.addObject("txn", txn);
		Users user = userDao.get(o.getUserID());
		m.addObject("user", user);
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
		m.addObject("items", l);
		return m;
	}	
	
	@RequestMapping("/orders/cancelorder/{orderid}")
	public String cancelOrder(@PathVariable("orderid") Integer id) {
		ordersDao.updateStatus(id, "CANCELLED");
		return "redirect:/admin/orders";
	}
	@RequestMapping("/items")
	public ModelAndView listItems() {
		ModelAndView m = new ModelAndView("admin/items");
		List<Items> items = itemsDao.getAll();
		m.addObject("items", items);
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
	
	@RequestMapping("/items/newitem")
	public ModelAndView newItem() {
		ModelAndView m = new ModelAndView("admin/newitem");
		List<Categories> l = categoryDao.getAll();
		m.addObject("cat", l);
		return m;
	}
	
	@RequestMapping("/items/process")
	public String process(@ModelAttribute Items item, @RequestParam("image") MultipartFile file) {
		storageService.save(file);
		Path p = Paths.get("uploads");
		Path q = p.resolve(file.getOriginalFilename());
		String s = q.toString();
		s = "/images/" + s;
		item.setItemImage(s);
		itemsDao.save(item);
		return "redirect:/admin/items";
	}
	
	@RequestMapping("/items/{itemid}")
	public String showItem(@PathVariable("itemid") Integer id, Model m) {
		Items i = itemsDao.get(id);
		Integer catid = i.getCategoryID();
		Categories c = categoryDao.get(catid);
		m.addAttribute("item", i);
		m.addAttribute("cat", c);
		return "/admin/showitem";
	}
	
	@RequestMapping("/items/disable/{itemid}")
	public String disableItem(@PathVariable("itemid") Integer id) {
		Items i = itemsDao.get(id);
		itemsDao.disable(i);
		return "redirect:/admin/items/" + i.getItemID().toString();
	}
	
	@RequestMapping("/items/enable/{itemid}")
	public String enableItem(@PathVariable("itemid") Integer id) {
		Items i = itemsDao.get(id);
		itemsDao.enable(i);
		return "redirect:/admin/items/" + i.getItemID().toString();
	}
	
	@RequestMapping("/items/edit/{itemid}")
	public String editItem(@PathVariable("itemid") Integer id, Model m) {
		Items i = itemsDao.get(id);
		m.addAttribute("item", i);
		List<Categories> l = categoryDao.getAll();
		m.addAttribute("cat", l);
		return "/admin/itemform";
	}
	
	@RequestMapping("/items/edit/process")
	public String editItemProcess(@ModelAttribute Items item,  @RequestParam("image") MultipartFile file, Model m) {
		Items initial = itemsDao.get(item.getItemID());
		if(!file.getOriginalFilename().isBlank()) {
			storageService.save(file);
			Path p = Paths.get("uploads");
			Path q = p.resolve(file.getOriginalFilename());
			String s = q.toString();
			s = "/images/" + s;
			item.setItemImage(s);
		}
		else {
			item.setItemImage(initial.getItemImage());
		}
		itemsDao.update(item);
		return "redirect:/admin/items/" + item.getItemID().toString();
	}
	
	@RequestMapping("/categories")
	public String categories(Model m) {
		List<Categories> l = categoryDao.getAll();
		m.addAttribute("cat", l);
		return "/admin/categories";
	}
	
	@RequestMapping("/categories/{cid}")
	public String categories(@PathVariable("cid") Integer id, Model m) {
		Categories c = categoryDao.get(id);
		m.addAttribute("cat", c);
		List<Items> l = itemsDao.getOfCategory(id);
		m.addAttribute("items", id);
		m.addAttribute("count", l.size());
		return "/admin/showcategory";
	}
	@RequestMapping("/categories/delete/{cid}")
	public String deleteCategory(@PathVariable("cid") Integer id, Model m) {
		Categories c = categoryDao.get(id);
		categoryDao.delete(c);
		return "redirect:/admin/categories";
	}
	
	@RequestMapping("/categories/edit/{cid}")
	public String editCategory(@PathVariable("cid") Integer id, Model m) {
		Categories c = categoryDao.get(id);
		m.addAttribute("c", c);
		return "/admin/categoryform";
	}
	
	@RequestMapping("/categories/edit/process")
	public String editCategory(@ModelAttribute Categories c, Model m) {
		categoryDao.update(c);
		return "redirect:/admin/categories";
	}
	
	@RequestMapping("/categories/newcategory")
	public String newCategory(Model m) {
		return "/admin/newcategory";
	}
	
	@RequestMapping("/categories/newcategory/process")
	public String newCategory(@ModelAttribute Categories c, Model m) {
		categoryDao.save(c);
		return "redirect:/admin/categories";
	}
	
	@RequestMapping("/transactions")
	public String transactions(Model m) {
		List<Transactions> l = transactionDao.getAll();
		m.addAttribute("txn", l);
		return "/admin/transactions";
	}
	
	@RequestMapping("/transactions/{txnid}")
	public String transactions(@PathVariable("txnid") String id, Model m) {
		Transactions t = transactionDao.get(id);
		m.addAttribute("t", t);
		Users u = userDao.get(t.getUserID());
		m.addAttribute("u", u);
		return "/admin/showtransaction";
	}
	
	@RequestMapping("/faq")
	public String Faq(Model m) {
		List<FAQ> l = (List<FAQ>) faqDao.getAll();
		m.addAttribute("faq", l);
		return "/admin/faq";
	}
	@RequestMapping("/faq/newfaq")
	public String newFaq(Model m) {
		return "/admin/newfaq";
	}
	
	@RequestMapping("/faq/newfaq/process")
	public String newFaq(@ModelAttribute FAQ faq, Model m) {
		faqDao.save(faq);
		return "redirect:/admin/faq";
	}
	
	@RequestMapping("/faq/{id}")
	public String editFaq(@PathVariable("id") Integer id, Model m) {
		FAQ f = faqDao.get(id);
		m.addAttribute("f", f);
		return "/admin/showfaq";
	}
	
	@RequestMapping("/faq/delete/{id}")
	public String deleteFaq(@PathVariable("id") Integer id, Model m) {
		FAQ f = faqDao.get(id);
		faqDao.delete(f);
		return "redirect:/admin/faq";
	}
	
	@RequestMapping("/faq/edit/process")
	public String editFaq(@ModelAttribute FAQ faq, Model m) {
		faqDao.update(faq);
		return "redirect:/admin/faq";
	}
	
	@RequestMapping("/gallery")
	public String gallery(Model m) {
		List<Gallery> l = (List<Gallery>) galleryDao.getAll();
		m.addAttribute("gallery", l);
		return "/admin/gallery";
	}
	
	@RequestMapping("/gallery/newphoto")
	public String newPhoto(Model m) {
		return "/admin/newphoto";
	}
	
	@RequestMapping("/gallery/newphoto/process")
	public String newPhoto(@ModelAttribute Gallery g, @RequestParam("photo") MultipartFile file, Model m) {
		g.setDateAdded(LocalDate.now().toString());
		storageService.save(file);
		Path p = Paths.get("uploads");
		Path q = p.resolve(file.getOriginalFilename());
		String s = q.toString();
		s = "/images/" + s;
		g.setImage(s);
		galleryDao.save(g);
		return "redirect:/admin/gallery";
	}
	
	@RequestMapping("/gallery/{id}")
	public String showphoto(@PathVariable("id") Integer id, Model m) {
		Gallery g = galleryDao.get(id);
		m.addAttribute("g", g);
		return "/admin/showphoto";
	}
	
	@RequestMapping("/gallery/edit/{id}")
	public String editPhoto(@PathVariable("id") Integer id, Model m) {
		Gallery g = galleryDao.get(id);
		m.addAttribute("g", g);
		return "/admin/photoform";
	}
	
	@RequestMapping("/gallery/delete/{id}")
	public String deletePhoto(@PathVariable("id") Integer id, Model m) {
		Gallery f = galleryDao.get(id);
		galleryDao.delete(f);
		return "redirect:/admin/gallery";
	}
	
	@RequestMapping("/gallery/edit/process")
	public String editPhoto(@ModelAttribute Gallery g, @RequestParam("photo") MultipartFile file, Model m) {
		Integer id = g.getPhotoID();
		Gallery f = galleryDao.get(id);
		if(!file.getOriginalFilename().isBlank()) {
			storageService.save(file);
			Path p = Paths.get("uploads");
			Path q = p.resolve(file.getOriginalFilename());
			String s = q.toString();
			s = "/images/" + s;
			g.setImage(s);
		}
		else {
			g.setImage(f.getImage());
		}
		galleryDao.update(g);
		return "redirect:/admin/gallery";
	}
	
	@RequestMapping("/feedbacks")
	public String feedback(Model m) {
		List<Feedbacks> l = (List<Feedbacks>) feedbacksDao.getAll();
		List<Feedbacks> ln = new LinkedList();
		for(Feedbacks c : l) {
			if(c.getStatus() == 0) {
				ln.add(c);
			}
		}
		for(Feedbacks c : l) {
			if(c.getStatus() == 1) {
				ln.add(c);
			}
		}
		m.addAttribute("feedback", ln);
		return "/admin/feedback";
	}
	
	@RequestMapping("/feedbacks/{id}")
	public String showFeedback(@PathVariable("id") Integer id, Model m) {
		Feedbacks f = feedbacksDao.get(id);
		m.addAttribute("f", f);
		return "/admin/showfeedback";
	}
	
	@RequestMapping("/feedbacks/resolve/{id}")
	public String resolveFeedback(@PathVariable("id") Integer id, Model m) {
		feedbacksDao.resolve(id);
		return "redirect:/admin/feedbacks";
	}
	
	@RequestMapping("/complaints")
	public String complaints(Model m) {
		List<Complaints> l = (List<Complaints>) complaintsDao.getAll();
		List<Complaints> ln = new LinkedList();
		for(Complaints c : l) {
			if(c.getStatus().equals("UNDER REVIEW")) {
				ln.add(c);
			}
		}
		for(Complaints c : l) {
			if(!c.getStatus().equals("UNDER REVIEW")) {
				ln.add(c);
			}
		}
		m.addAttribute("complaints", ln);
		return "/admin/complaint";
	}
	
	@RequestMapping("/complaints/{id}")
	public String showComplaint(@PathVariable("id") Integer id, Model m) {
		Complaints c = complaintsDao.get(id);
		m.addAttribute("c", c);
		return "/admin/showcomplaint";
	}
	
	@RequestMapping("/complaints/resolve/{id}")
	public String resolveComplaint(@PathVariable("id") Integer id, Model m) {
		complaintsDao.resolve(id);
		return "redirect:/admin/complaints";
	}
	
	@RequestMapping("/parameters")
	public String parameters(Model m) {
		List<Parameters> l = parameterDao.getAll();
		m.addAttribute("parameters", l);
		return "/admin/parameters";
	}
	
	@RequestMapping("/parameters/update")
	public String parameters(@ModelAttribute Parameters p, Model m) {
		parameterDao.update(p);
		return "redirect:/admin/parameters";
	}
}
