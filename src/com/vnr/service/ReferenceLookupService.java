package com.vnr.service;

import java.util.List;

import com.vnr.model.StateRef;

public interface ReferenceLookupService {

	List<StateRef> searchByStateNameLike(String stateName);
	StateRef searchByStateName(String stateName);
	
}
