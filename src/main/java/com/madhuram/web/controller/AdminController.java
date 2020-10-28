package com.madhuram.web.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.madhuram.web.dao.ItemsDao;
import com.madhuram.web.dao.OrdersDao;
import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.Items;
import com.madhuram.web.entities.Orders;
import com.madhuram.web.entities.Users;
import com.madhuram.web.services.SecurityService;
import com.madhuram.web.services.SecurityServiceImpl;

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
	private SecurityService securityService;
	
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
		m.addObject("users", ret);
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
	@RequestMapping("/admins")
	public ModelAndView listAdmins() {
		ModelAndView m = new ModelAndView("admin/admins");
		List<Users> users = userDao.getAll();
		List<Users> ret = new LinkedList<>();
		for(Users user: users) {
			if(user.getAuthority().equals("ROLE_admin")) ret.add(user);
		}
		m.addObject("users", ret);
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
	@RequestMapping("/orders")
	public ModelAndView listOrders() {
		ModelAndView m = new ModelAndView("admin/orders");
		List<Orders> orders = ordersDao.getAll();
		m.addObject("orders", orders);
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
	@RequestMapping("/items")
	public ModelAndView listItems() {
		ModelAndView m = new ModelAndView("admin/items");
		List<Items> items = itemsDao.getAll();
		m.addObject("items", items);
		m.addObject("email", securityService.findLoggedInUsername());
		return m;
	}
}
