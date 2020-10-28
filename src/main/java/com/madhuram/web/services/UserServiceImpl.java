package com.madhuram.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.madhuram.web.dao.UserDao;
import com.madhuram.web.entities.Users;


@Service
public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public Users findByUsername(String username) {
		return userDao.get(username);
	}


}
