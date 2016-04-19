package com.vnr.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vnr.model.VehicleInsurance;
import com.vnr.util.HibernateUtil;

@Repository
public class VehicleInsuranceDAOImpl implements VehicleInsuranceDAO {
	//private static final Log log = LogFactory.getLog(VehicleInsuranceDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public void saveVehicleInsurance(VehicleInsurance vehicleInsurance) {
		
		this.setAuditableField(vehicleInsurance);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(vehicleInsurance);
		session.getTransaction().commit();		
		session.close();
	}
	
	public VehicleInsurance selectVehicleInsuranceByUnitNum(String unitNumber) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(VehicleInsurance.class);		 
		criteria.add(Restrictions.eq("unitNumber", unitNumber));
		VehicleInsurance vehicleInsurance = (VehicleInsurance)criteria.uniqueResult();
		 
		session.close();
		
		return vehicleInsurance;
	}
	
	private void setAuditableField(VehicleInsurance vehicleInsurance) {
		vehicleInsurance.setCreatedBy("user");
		vehicleInsurance.setCreatedDate(new Date());
		vehicleInsurance.setLastModifiedBy("user");
		vehicleInsurance.setLastModifiedDate(new Date());
	}
}
