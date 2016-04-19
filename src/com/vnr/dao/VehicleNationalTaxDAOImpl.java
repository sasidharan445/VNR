package com.vnr.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vnr.model.VehicleNationalTax;
import com.vnr.util.HibernateUtil;

@Repository
public class VehicleNationalTaxDAOImpl implements VehicleNationalTaxDAO {
	//private static final Log log = LogFactory.getLog(VehicleNationalTaxDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public void saveVehicleNationalTax(VehicleNationalTax vehicleNationalTax) {
		
		this.setAuditableField(vehicleNationalTax);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(vehicleNationalTax);
		session.getTransaction().commit();		
		session.close();
	}
	
	public VehicleNationalTax selectVehicleNationalTaxByUnitNum(String unitNumber) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(VehicleNationalTax.class);		 
		criteria.add(Restrictions.eq("unitNumber", unitNumber));
		VehicleNationalTax vehicleNationalTax = (VehicleNationalTax)criteria.uniqueResult();
		 
		session.close();
		
		return vehicleNationalTax;
	}
	
	private void setAuditableField(VehicleNationalTax vehicleNationalTax) {
		vehicleNationalTax.setCreatedBy("user");
		vehicleNationalTax.setCreatedDate(new Date());
		vehicleNationalTax.setLastModifiedBy("user");
		vehicleNationalTax.setLastModifiedDate(new Date());
	}
}
