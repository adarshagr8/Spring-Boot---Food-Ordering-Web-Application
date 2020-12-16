package com.madhuram.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.Users;
import com.madhuram.web.services.SecurityService;
@Controller
public class RegisterController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;
    
    @Autowired
	private SecurityService securityService;
    
    @RequestMapping(path = "/register", method=RequestMethod.GET)
	public String register() {
		if(securityService.findLoggedInUsername() != null) {
			return "redirect:/";
		}
		return "register";
	}
    
    @RequestMapping("/register-success")
   	public String registerSuccess() {
   		return "redirect:/";
   	}
       
    @RequestMapping(path = "/register", method=RequestMethod.POST)
    public String register(@ModelAttribute Users user) {
        String encodedPassword  = passwordEncoder.encode(user.getPassword());
        user.setEnabled(Boolean.TRUE);
        user.setPassword(encodedPassword);
        user.setAuthority("user");
        user.setCreatedDate(LocalDate.now().toString());
        userDao.save(user);
        securityService.autoLogin(user.getEmailAddress(), encodedPassword);
        return "redirect:register-success";
    }
}
