package com.vnr.service;

import org.springframework.stereotype.Service;

import com.vnr.model.UserAccount;

@Service
public interface LoginService {
	

	UserAccount selectUserAccount(UserAccount userAccount);
}
