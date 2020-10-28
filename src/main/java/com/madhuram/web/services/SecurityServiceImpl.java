package com.madhuram.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	public SecurityServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails instanceof UserDetails) {
			return ((UserDetails)userDetails).getUsername();
		}
			
		return null;
	}

	@Override
	public void autoLogin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
        		new UsernamePasswordAuthenticationToken(
                userDetails, password, userDetails.getAuthorities());
        try {
        	authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }
        catch(Exception e){
        	System.out.println(e);
        }
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
	}

	@Override
	public void autoLogout() {
		SecurityContextHolder.clearContext();
		
	}

}
