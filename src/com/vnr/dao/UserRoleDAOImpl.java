package com.vnr.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.vnr.model.UserRole;
import com.vnr.util.HibernateUtil;

public class UserRoleDAOImpl  implements UserRoleDAO {
	private static final Log log = LogFactory.getLog(VehicleFinanceDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<UserRole> selectRolesByUserAccountID(Long userAccountId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserRole.class);		 
		criteria.add(Restrictions.eq("userAccountId", userAccountId));
		@SuppressWarnings("unchecked")
		List<UserRole> roles = criteria.list();
		 
		session.close();
		log.info("Roles:"+ roles);
		return roles;
	}

}
