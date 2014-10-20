package be.jebouquine.controlers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import be.jebouquine.business.interfaces.IClientBusiness;
import be.jebouquine.business.interfaces.IOrderBusinessFront;
import be.jebouquine.entities.Client;
import be.jebouquine.modelview.Cart;
import be.jebouquine.modelview.OrderCreation;
import be.jebouquine.modelview.SessionAccount;

public class FOOrderAction implements SessionAware {
	private static final String OC_KEY="orderCreation";
	private static final String SA_KEY = "sessionAccount";
	private static final String CART_KEY="cart";
	private Map<String,Object> session;
	private IOrderBusinessFront orderBusinessFront;
	private IClientBusiness clientBusiness;
	
	// METHOD ACTION 1
	private String addressOfDelivery;
	
	public String prepStep1(){ // Output addressOfDelivery to jsp
		try {
			OrderCreation oc=orderBusinessFront.getNewOrderCreation();
			session.put(OC_KEY, oc);
			SessionAccount sa = (SessionAccount) session.get(SA_KEY);
			addressOfDelivery = clientBusiness.findByID(sa.getId()).getAdress();
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	
	// METHOD ACTION 2
	public String prepStep2(){ // Input addressOfDelivery from jsp
		try {
			OrderCreation oc = (OrderCreation) session.get(OC_KEY);
			if(!orderBusinessFront.stepA(oc, addressOfDelivery))
				return "failure";
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	
	// METHOD ACTION 3
	private String  paymentInfos; // IN
	private String orderRef; // OUT
	
	public String prepStep3(){ // Input paymentInfos from jsp, output orderId to jsp
		try {
			OrderCreation oc = (OrderCreation) session.get(OC_KEY);
			
			SessionAccount sa = (SessionAccount) session.get(SA_KEY);
			Client client = clientBusiness.findByID(sa.getId());
			
			Cart cart=(Cart) session.get(CART_KEY);
			
			if(!orderBusinessFront.stepB(oc, paymentInfos))
				return "failure";
			orderRef=orderBusinessFront.stepC(oc, client, cart);
			if(orderRef==null)
				return "failure";
			else{
				session.remove(CART_KEY);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public IClientBusiness getClientBusiness() {
		return clientBusiness;
	}


	public void setClientBusiness(IClientBusiness clientBusiness) {
		this.clientBusiness = clientBusiness;
	}

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

	public String getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public IOrderBusinessFront getOrderBusinessFront() {
		return orderBusinessFront;
	}

	public void setOrderBusinessFront(IOrderBusinessFront orderBusinessFront) {
		this.orderBusinessFront = orderBusinessFront;
	}


}
