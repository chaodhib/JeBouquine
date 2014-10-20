package be.jebouquine.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.interfaces.IBookBusiness;
import be.jebouquine.business.interfaces.IOrderBusinessFront;
import be.jebouquine.business.interfaces.IPaymentBusiness;
import be.jebouquine.business.singletons.OrderBusinessSingleton;
import be.jebouquine.dao.interfaces.IOrderDAO;
import be.jebouquine.dao.interfaces.IOrderStateDAO;
import be.jebouquine.entities.Client;
import be.jebouquine.entities.Order;
import be.jebouquine.entities.OrderLine;
import be.jebouquine.entities.OrderState;
import be.jebouquine.modelview.Cart;
import be.jebouquine.modelview.CartLine;
import be.jebouquine.modelview.OrderCreation;
import be.jebouquine.modelview.OrderView;

@Transactional(readOnly = false)
public class OrderBusinessFrontImpl implements IOrderBusinessFront {
	private IPaymentBusiness paymentBusiness;
	private IBookBusiness bookBusiness;
	private IOrderDAO orderDAO;
	private IOrderStateDAO orderStateDAO;
	private OrderBusinessSingleton orderBusinessSingleton;

	@Override
	public OrderView findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderView> findByClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderCreation getNewOrderCreation() {
		return new OrderCreation();
	}

	@Override
	public boolean stepA(OrderCreation oc, String addressOfDelivery) {
		if (validationAddress(addressOfDelivery)) {
			oc.setAddressOfDelivery(addressOfDelivery);
			return true;
		} else
			return false;
	}

	/**
	 * Place where the regex would be
	 * 
	 * @param adressOfDelivery
	 * @return
	 */
	private boolean validationAddress(String addressOfDelivery) {
		return true;
	}

	@Override
	public boolean stepB(OrderCreation oc, String paymentInfos) {
		if (validationPaymentInfos(paymentInfos)) {
			oc.setPaymentInfos(paymentInfos);
			return true;
		} else
			return false;
	}

	/**
	 * Place where the regex would be
	 * 
	 * @param paymentInfos
	 * @return
	 */
	private boolean validationPaymentInfos(String paymentInfos) {
		return true;
	}

	@Override
	public String stepC(OrderCreation oc, Client client, Cart cart) throws Exception {
		if (paymentBusiness.makePayment(oc.getPaymentInfos(),
				cart.getTotalPrice())) {
			Order order = new Order();
			order.setAddress(oc.getAddressOfDelivery());
			order.setClient(client);
			Calendar calendar=new GregorianCalendar();
			order.setDate(calendar);
			// CartLines -> OrderLines
			OrderLine ol;
			List<OrderLine> orderlines = new ArrayList<OrderLine>();

			for (CartLine cl : cart.getLines()) {
				ol = new OrderLine();
				ol.setBook(bookBusiness.findByID(cl.getBookId()));
				ol.setPrice(cl.getSubTotalPrice());
				ol.setQuantity(cl.getQuantity());
				orderlines.add(ol);
			}
			order.setOrderLines(orderlines);

			// Order State

			OrderState os = orderStateDAO.findByID(1);
			order.setOrderState(os);

			// Order ref
			
			String orderRef;
			try {
				int year=calendar.get(Calendar.YEAR);
				String orderNumber=String.format("%04d", orderBusinessSingleton.getNextOrderNumber());
				orderRef = "JB"+year+orderNumber;
			} catch (Exception e) {
				throw new Exception(e);
			}
			order.setOrderRef(orderRef);

			// persister l'order
			try {
				orderDAO.add(order);
			} catch (Exception e) {
				throw new Exception(e);
			}

			// renvoyer vers la vue la reference de l'order
			return orderRef;
		} else
			throw new Exception("Payment validation failed");
	}

	@Override
	public boolean cancelOrder(Integer orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyOrderLine(Order order, Integer bookId,
			Integer desiredQty) {
		// TODO Auto-generated method stub
		return false;
	}

	public IPaymentBusiness getPaymentBusiness() {
		return paymentBusiness;
	}

	public void setPaymentBusiness(IPaymentBusiness paymentBusiness) {
		this.paymentBusiness = paymentBusiness;
	}

	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public IBookBusiness getBookBusiness() {
		return bookBusiness;
	}

	public void setBookBusiness(IBookBusiness bookBusiness) {
		this.bookBusiness = bookBusiness;
	}

	public IOrderStateDAO getOrderStateDAO() {
		return orderStateDAO;
	}

	public void setOrderStateDAO(IOrderStateDAO orderStateDAO) {
		this.orderStateDAO = orderStateDAO;
	}

	public OrderBusinessSingleton getOrderBusinessSingleton() {
		return orderBusinessSingleton;
	}

	public void setOrderBusinessSingleton(OrderBusinessSingleton orderBusinessSingleton) {
		this.orderBusinessSingleton = orderBusinessSingleton;
	}

}
