package com.madhuram.web.services;

public interface SecurityService {
	
	public String findLoggedInUsername();
    public void autoLogin(String username, String password);
    public void autoLogout();

}
