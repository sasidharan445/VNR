package com.vnr.dao;

import java.util.List;

import com.vnr.model.UserRole;

public interface UserRoleDAO {
	List<UserRole> selectRolesByUserAccountID(Long userAccountId);
}
