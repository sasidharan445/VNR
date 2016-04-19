package com.vnr.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vnr.model.VehicleStateTax;
import com.vnr.util.HibernateUtil;

@Repository
public class VehicleStateTaxDAOImpl implements VehicleStateTaxDAO {
	//private static final Log log = LogFactory.getLog(VehicleStateTaxDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public void saveVehicleStateTax(VehicleStateTax vehicleStateTax) {
		
		this.setAuditableField(vehicleStateTax);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(vehicleStateTax);
		session.getTransaction().commit();		
		session.close();
	}
	
	public VehicleStateTax selectVehicleStateTaxByUnitNum(String unitNumber) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(VehicleStateTax.class);		 
		criteria.add(Restrictions.eq("unitNumber", unitNumber));
		VehicleStateTax vehicleStateTax = (VehicleStateTax)criteria.uniqueResult();
		 
		session.close();
		
		return vehicleStateTax;
	}
	
	private void setAuditableField(VehicleStateTax vehicleStateTax) {
		vehicleStateTax.setCreatedBy("user");
		vehicleStateTax.setCreatedDate(new Date());
		vehicleStateTax.setLastModifiedBy("user");
		vehicleStateTax.setLastModifiedDate(new Date());
	}
}
