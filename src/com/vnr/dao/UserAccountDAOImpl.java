package com.vnr.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vnr.model.UserAccount;
import com.vnr.util.HibernateUtil;

@Repository
public class UserAccountDAOImpl implements UserAccountDAO {
	
	private static final Log log = LogFactory.getLog(UserAccountDAOImpl.class);
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public UserAccount selectUserAccount(UserAccount userAccount) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserAccount where loginName=:loginName and password=:password");
		query.setString("loginName", userAccount.getLoginName());
		query.setString("password", userAccount.getPassword());		
		return (UserAccount)query.uniqueResult();
	}
	
	public UserAccount selectUserAccount(String name) {
		Session session = sessionFactory.openSession();
		log.info("login Name: "+ name);
		Query query = session.createQuery("from UserAccount where loginName=:loginName");
		UserAccount userAccount = (UserAccount)query.setString("loginName", name).uniqueResult();
		log.info("login Name: "+ userAccount.getUserRoles().size());
		return userAccount;
	}
}
