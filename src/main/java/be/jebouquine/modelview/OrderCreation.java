package be.jebouquine.modelview;

import be.jebouquine.dao.interfaces.IClientDAO;
import be.jebouquine.entities.Client;

public class OrderCreation {

	private String addressOfDelivery;
	private String paymentInfos;

	public String getPaymentInfos() {
		return paymentInfos;
	}

	public void setPaymentInfos(String paymentInfos) {
		this.paymentInfos = paymentInfos;
	}

	public String getAddressOfDelivery() {
		return addressOfDelivery;
	}

	public void setAddressOfDelivery(String addressOfDelivery) {
		this.addressOfDelivery = addressOfDelivery;
	}
	
	
}
