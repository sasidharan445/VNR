package com.vnr.dao;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vnr.model.VehicleFinance;
import com.vnr.util.HibernateUtil;

@Repository
public class VehicleFinanceDAOImpl implements VehicleFinanceDAO {
	private static final Log log = LogFactory.getLog(VehicleFinanceDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public void saveVehicleFinance(VehicleFinance vehicleFinance) throws HibernateException {
		Session session = sessionFactory.openSession();
		try {
			this.setAuditableField(vehicleFinance);			
			session.beginTransaction();
			session.saveOrUpdate(vehicleFinance);
			session.getTransaction().commit();		
			
		} catch(HibernateException hex) {
			log.error(hex.getMessage());
			throw hex;
		}finally {
			if(session != null) session.close();
		}
	}
	
	public VehicleFinance selectVehicleFinanceByUnitNum(String unitNumber) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(VehicleFinance.class);		 
		criteria.add(Restrictions.eq("unitNumber", unitNumber));
		VehicleFinance vehicleFinance = (VehicleFinance)criteria.uniqueResult();
		 
		session.close();
		
		return vehicleFinance;
	}
	
	private void setAuditableField(VehicleFinance vehicleFinance) {
		vehicleFinance.setCreatedBy("user");
		vehicleFinance.setCreatedDate(new Date());
		vehicleFinance.setLastModifiedBy("user");
		vehicleFinance.setLastModifiedDate(new Date());
	}
}
