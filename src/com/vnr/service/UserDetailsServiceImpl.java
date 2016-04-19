package com.vnr.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vnr.dao.UserAccountDAO;
import com.vnr.model.UserAccount;
import com.vnr.model.UserRole;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Log log = LogFactory.getLog(UserDetailsServiceImpl.class);
	@Autowired UserAccountDAO userAccountDAO;
	
	@Override	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserAccount userAccount = this.userAccountDAO.selectUserAccount(userName);          
       
        if (userAccount == null){
            throw new UsernameNotFoundException("User not found");
        } else {        	
        	UserDetails user = buildUserObject(userAccount);
        	log.info("user: "+user.getUsername());
        	log.info("user Role: "+user.getAuthorities());
        	return user;
        }
    }
	
	private User buildUserObject(UserAccount userAccount) {		
		
	    String password = userAccount.getPassword();
	    String username = userAccount.getLoginName();	    
	    return new User(username, password, true, true, true, true, getAuthorities(userAccount.getUserRoles()));	    		 	    
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Set<UserRole> roles) {
	    List<GrantedAuthority> authList = getGrantedAuthorities(getRolesAsList(roles));
	    return authList;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (String role : roles) {
	        authorities.add(new SimpleGrantedAuthority(role));
	    }
	    return authorities;
	}
	
	public List<String> getRolesAsList(Set<UserRole> roles) {
	    List <String> rolesAsList = new ArrayList<String>();
	    for(UserRole role : roles){
	        rolesAsList.add(role.getRoleName());
	    }
	    return rolesAsList;
	}
}
