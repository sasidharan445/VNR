package com.vnr.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vnr.constant.CommonConstants;
import com.vnr.model.VehicleInformation;
import com.vnr.util.HibernateUtil;

@Repository
public class VehicleInformationDAOImpl implements VehicleInformationDAO {
	private static final Log log = LogFactory.getLog(VehicleInformationDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public VehicleInformation selectVehicleInformation(String unitNumber) {
		Session session = sessionFactory.openSession();
		 
		Criteria criteria = session.createCriteria(VehicleInformation.class);		 
		criteria.add(Restrictions.eq("unitNumber", unitNumber));
		VehicleInformation vehicleMaster = (VehicleInformation)criteria.uniqueResult();
		 
		session.close();
		
		return vehicleMaster;
	}
	
	@SuppressWarnings("unchecked")
	public List<VehicleInformation> searchByUnitNumLike(String unitNumber) {
		Session session = sessionFactory.openSession();
		log.info("unitNumber	"+unitNumber);		 
		Criteria criteria = session.createCriteria(VehicleInformation.class);		 
		criteria.add(Restrictions.like("unitNumber", unitNumber, MatchMode.START));
		criteria.add(Restrictions.eq("vehicleStatus", "Active"));
		List<VehicleInformation> vehicles = criteria.list();
		 
		session.close();
		log.info("vehicles	"+vehicles);	
		return vehicles;
	}
	
	public String selectLatestUnitNumber(String vehicleTypeCode) {
		Session session = sessionFactory.openSession();	
		log.info("vehicleTypeCode	"+vehicleTypeCode);		 
		Criteria criteria = session.createCriteria(VehicleInformation.class);		 
		criteria.add(Restrictions.like("unitNumber", vehicleTypeCode, MatchMode.START));
		if(vehicleTypeCode.equals(CommonConstants.TRUCK_CODE)) {
			criteria.add(Restrictions.not(Restrictions.like("unitNumber", "TR%")));
		}
		criteria.setProjection(Projections.max("unitNumber"));
		String unitNum = (String)criteria.uniqueResult();
		log.info("vehicle	"+unitNum);
		session.close();
		
		return unitNum;
	}
	
	@SuppressWarnings("unchecked")
	public List<VehicleInformation> selectActiveVehicles() {
		Session session = sessionFactory.openSession();		
		List<VehicleInformation> vehicles = session.getNamedQuery("SELECT_ACTIVE_VEHICLES").list();
		/*Criteria criteria = session.createCriteria(VehicleInformation.class);		 
		criteria.add(Restrictions.eq("vehicleStatus", "Active"));
		criteria.add(Restrictions.eq("vehicleStatus", "Active"));
		List<VehicleInformation> vehicles = criteria.list();*/
		 
		session.close();
		
		return vehicles;
	}
	
	public void saveVehicleInformation(VehicleInformation vehicleInfo) {
		
		this.setAuditableField(vehicleInfo);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(vehicleInfo);
		session.getTransaction().commit();		
		session.close();
	}
	
	private void setAuditableField(VehicleInformation vehicleInfo) {
		vehicleInfo.setCreatedBy("user");
		vehicleInfo.setCreatedDate(new Date());
		vehicleInfo.setLastModifiedBy("user");
		vehicleInfo.setLastModifiedDate(new Date());
	}
}
