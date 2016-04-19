package com.vnr.security;

import org.springframework.security.core.GrantedAuthority;

public class UserGrantedAuthority implements GrantedAuthority {
	
	private static final long serialVersionUID = -3786297951121082644L;
	private String authority = null;
	private String[] authorities = null;
	    
	public UserGrantedAuthority(String[] auths) { 
		 authorities = auths; 
	}

	public UserGrantedAuthority(String auth) { 
		 authority = auth; 
	}
    
	@Override
    public String getAuthority() { return authority; }
    	    
    public String[] getAuthorities() { return authorities; }
}

