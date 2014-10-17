package be.jebouquine.business.interfaces;

public interface IPaymentBusiness {
	public boolean makePayment(String paymentInfos, Double amount);
}
