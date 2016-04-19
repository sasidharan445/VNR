package com.vnr.dao;

import java.util.List;

import com.vnr.model.StateRef;

public interface StateRefDAO {
	List<StateRef> searchByStateNameLike(String stateName);
	StateRef searchByStateName(String stateName);
}
