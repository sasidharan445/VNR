package com.vnr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnr.dao.StateRefDAO;
import com.vnr.model.StateRef;

@Service
public class ReferenceLookupServiceImpl implements ReferenceLookupService {

	@Autowired StateRefDAO stateRefDAO;
	
	public List<StateRef> searchByStateNameLike(String stateName) {
		return stateRefDAO.searchByStateNameLike(stateName);
	}
	
	public StateRef searchByStateName(String stateName) {
		return stateRefDAO.searchByStateName(stateName);
	}
}
