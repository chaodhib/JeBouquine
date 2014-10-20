package be.jebouquine.business.interfaces;

import be.jebouquine.entities.Client;
import be.jebouquine.entities.Order;
import be.jebouquine.modelview.Cart;
import be.jebouquine.modelview.OrderCreation;

public interface IOrderBusinessFront extends IOrderBusiness {
	// TODO : mettre les méthodes communes entre bakc & front office dans l'interface parent
	
	public OrderCreation getNewOrderCreation();
	
	/**input & validation of adressOfDelivery
	 * 
	 * 
	 * @param oc
	 * @param adressOfDelivery
	 * @return
	 */
	public boolean stepA(OrderCreation oc, String  adressOfDelivery);
	
	/**input & validation of paymentInfos
	 * 
	 * 
	 * @param oc
	 * @param paymentInfos
	 * @return
	 */
	public boolean stepB(OrderCreation oc, String  paymentInfos);
	
	/**execute payment, create the Order 
	 * in the DB and set OrderID in OrderCreation for display in the view tier
	 * 
	 * return the orderRef is the step has been successful. If not, returns null
	 * @param oc
	 * @param client
	 * @param cart
	 * @return
	 * @throws Exception 
	 */
	public String stepC(OrderCreation oc, Client client, Cart cart) throws Exception;
	
	/**
	 * 
	 * @param orderId
	 * @return 
	 * true if the canceling succeded
	 * false if it's too late to cancel the order
	 */
	public boolean cancelOrder(Integer orderId);
	
	/** TODO: by reference to object order or by orderId
	 * 
	 * @param
	 * @return 
	 * true if the change succeded
	 * false if it's too late to modify the order
	 */
	public boolean modifyOrderLine(Order order, Integer bookId, Integer desiredQty);
}
