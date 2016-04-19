package com.vnr.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vnr.constant.CommonConstants;
import com.vnr.model.Payment;
import com.vnr.parameter.PaymentRequest;
import com.vnr.util.HibernateUtil;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
	private static final Log log = LogFactory.getLog(PaymentDAOImpl.class);
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public void savePayment(Payment payment) {	
		
		this.setAuditableField(payment);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(payment);
		session.getTransaction().commit();				
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Payment> selectPaymentsByObject(PaymentRequest request) {
		Session session = sessionFactory.openSession();
		String qry = "select payment from Payment payment ";
		String joinQry = "";		 
		if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_FINANCE)) {
			joinQry = " join payment.vehicleFinance vehicleFinance " +
					  " where vehicleFinance.unitNumber= :unitNumber" ;
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_NATIONAL_TAX)) {
			joinQry = " join payment.vehicleNationalTax  vehicleNationalTax"+
					  " where vehicleNationalTax.unitNumber= :unitNumber" ;
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_STATE_TAX)) {
			joinQry = " join payment.vehicleStateTax vehicleStateTax "+
					  " where vehicleStateTax.unitNumber= :unitNumber" ;
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_NATIONAL_PERMIT)) {
			joinQry = " join payment.vehicleNationalPermit vehicleNationalPermit "+
					  " where vehicleNationalPermit.unitNumber= :unitNumber" ;
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_INSURANCE)) {
			joinQry = " join payment.vehicleInsurance vehicleInsurance "+
					  " where vehicleInsurance.unitNumber= :unitNumber" ;
		}
		
		qry = qry.concat(joinQry);
				
		log.info("request.getUnitNumber():	"+request.getUnitNumber());
		Query query = session.createQuery(qry);		
		      query.setParameter("unitNumber", request.getUnitNumber());
		
		return   query.list();
	}
		
	public Payment selectLatestPaymentByObject(PaymentRequest request) {
		Session session = sessionFactory.openSession();
		String qry = "select payment from Payment payment ";
		String joinQry = "";	
		if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_FINANCE)) {
			joinQry = " join payment.vehicleFinance vehicleFinance " +
					  " where vehicleFinance.unitNumber= :unitNumber order by payment.createdDate DESC" ;
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_NATIONAL_TAX)) {
			joinQry = " join payment.vehicleNationalTax  vehicleNationalTax"+
					  " where vehicleNationalTax.unitNumber= :unitNumber order by payment.createdDate DESC" ;
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_STATE_TAX)) {
			joinQry = " join payment.vehicleStateTax vehicleStateTax "+
					  " where vehicleStateTax.unitNumber= :unitNumber order by payment.createdDate DESC" ;
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_NATIONAL_PERMIT)) {
			joinQry = " join payment.vehicleNationalPermit vehicleNationalPermit "+
					  " where vehicleNationalPermit.unitNumber= :unitNumber order by payment.createdDate DESC" ;
		} else if(request.getPaymentObject().equals(CommonConstants.PAYMENT_OBJECT_INSURANCE)) {
			joinQry = " join payment.vehicleInsurance vehicleInsurance "+
					  " where vehicleInsurance.unitNumber= :unitNumber order by payment.createdDate DESC" ;
		}
		
		qry = qry.concat(joinQry);
		
		Payment pyment = (Payment) session.createQuery(qry)		
					  	 .setParameter("unitNumber", request.getUnitNumber())
					     .setMaxResults(1)
					     .uniqueResult();
		return pyment;
	}
	
	private void setAuditableField(Payment payment) {
		payment.setCreatedBy("user");
		payment.setCreatedDate(new Date());
		payment.setLastModifiedBy("user");
		payment.setLastModifiedDate(new Date());
	}
}
