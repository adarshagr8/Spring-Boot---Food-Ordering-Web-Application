package com.madhuram.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.madhuram.web.dao.FAQDao;
import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.FAQ;
import com.madhuram.web.services.SecurityService;

@Controller
public class FrontController {
	@Autowired
	public UserDao userdao;
	@Autowired
	public FAQDao faq;
	@Autowired
	private SecurityService securityService;
	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("username", securityService.findLoggedInUsername());
	}
	
	@RequestMapping("/")
	public String home(Model m) {
		return "home";
	}
	@RequestMapping("/about")
	public String about(Model m) {
		return "about";
	}
	@RequestMapping("/faq")
	public String faq(Model m) {
		List<FAQ> questions = faq.getAll();
		m.addAttribute("questions", questions);
		return "faq";
	}
}
