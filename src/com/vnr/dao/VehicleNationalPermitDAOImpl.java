package com.vnr.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vnr.model.VehicleNationalPermit;
import com.vnr.util.HibernateUtil;

@Repository
public class VehicleNationalPermitDAOImpl implements VehicleNationalPermitDAO {
	//private static final Log log = LogFactory.getLog(VehicleNationalPermitDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public void saveVehicleNationalPermit(VehicleNationalPermit vehicleNationalPermit) {
		
		this.setAuditableField(vehicleNationalPermit);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(vehicleNationalPermit);
		session.getTransaction().commit();		
		session.close();
	}
	
	public VehicleNationalPermit selectVehicleNationalPermitByUnitNum(String unitNumber) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(VehicleNationalPermit.class);		 
		criteria.add(Restrictions.eq("unitNumber", unitNumber));
		VehicleNationalPermit vehicleNationalPermit = (VehicleNationalPermit)criteria.uniqueResult();
		 
		session.close();
		
		return vehicleNationalPermit;
	}
	
	private void setAuditableField(VehicleNationalPermit vehicleNationalPermit) {
		vehicleNationalPermit.setCreatedBy("user");
		vehicleNationalPermit.setCreatedDate(new Date());
		vehicleNationalPermit.setLastModifiedBy("user");
		vehicleNationalPermit.setLastModifiedDate(new Date());
	}
}
