package com.vnr.dao;

import com.vnr.model.UserAccount;

public interface UserAccountDAO {
	UserAccount selectUserAccount(UserAccount userAccount);
	UserAccount selectUserAccount(String name);	
}
