package com.madhuram.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.madhuram.web.entities.Users;
import com.madhuram.web.services.SecurityService;

@Controller
public class LoginController {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/login")
	public String login() {
		if(securityService.findLoggedInUsername() != null) {
			return "redirect:/";
		}
		return "login";
	}
	
	@PostMapping("/processLogin")
	public String login(@ModelAttribute Users user) {
		securityService.autoLogin(user.getEmailAddress(), user.getPassword());
		return "redirect:/";
	}
}
