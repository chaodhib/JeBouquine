package be.jebouquine.business.impl;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.interfaces.IPaymentBusiness;

@Transactional(readOnly = false)
public class PaymentBusinessImpl implements IPaymentBusiness {

	@Override
	public boolean makePayment(String paymentInfos, Double amount) {
		return true;
	}
	
}
