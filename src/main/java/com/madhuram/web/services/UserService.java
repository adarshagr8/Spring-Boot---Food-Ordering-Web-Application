package com.madhuram.web.services;

import com.madhuram.web.entities.Users;

public interface UserService {
	void save(Users user);
	Users findByUsername(String username);
}
