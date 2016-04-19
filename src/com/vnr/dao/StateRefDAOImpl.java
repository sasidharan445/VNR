package com.vnr.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vnr.model.StateRef;
import com.vnr.util.HibernateUtil;

@Repository
public class StateRefDAOImpl implements StateRefDAO {
	private static final Log log = LogFactory.getLog(StateRefDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@SuppressWarnings("unchecked")
	public List<StateRef> searchByStateNameLike(String stateName) {
		
		Session session = sessionFactory.openSession();
		log.info("stateName	"+stateName);		 
		Criteria criteria = session.createCriteria(StateRef.class);		 
		criteria.add(Restrictions.like("stateName", stateName, MatchMode.START));		
		List<StateRef> states = criteria.list();
		 
		session.close();
		
		return states;
		
	}
	
	public StateRef searchByStateName(String stateName) {
		
		Session session = sessionFactory.openSession();
		log.info("stateName	"+stateName);		 
		Criteria criteria = session.createCriteria(StateRef.class);		 
		criteria.add(Restrictions.eq("stateName", stateName));		
		StateRef state = (StateRef)criteria.uniqueResult();
		 
		session.close();
		
		return state;
		
	}
}
