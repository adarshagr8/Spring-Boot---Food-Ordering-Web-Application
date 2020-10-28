package com.madhuram.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.Users;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDao.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Email Address");
        }
        List<GrantedAuthority> grantList = new ArrayList<>();

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getAuthority());
        grantList.add(authority);
        return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(), grantList);
    
	}		
	

}
