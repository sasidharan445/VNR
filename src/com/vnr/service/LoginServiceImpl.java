package com.vnr.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnr.dao.UserAccountDAO;
import com.vnr.model.UserAccount;

@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Log log = LogFactory.getLog(LoginServiceImpl.class);
	
	@Autowired UserAccountDAO userAccountDAO;	
	
	public UserAccount selectUserAccount(UserAccount userAccount) {
		return userAccountDAO.selectUserAccount(userAccount);
		
	}
	
}
