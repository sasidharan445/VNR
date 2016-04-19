package com.vnr.dao;

import java.util.List;

import com.vnr.model.Payment;
import com.vnr.parameter.PaymentRequest;


public interface PaymentDAO {
	void savePayment(Payment payment);
	List<Payment> selectPaymentsByObject(PaymentRequest request);
	Payment selectLatestPaymentByObject(PaymentRequest request);
}
