package be.jebouquine.modelview;

import be.jebouquine.entities.Order;
import be.jebouquine.entities.OrderLine;

public class OrderView {

	private Order order;
	private Double totalPrice;

	public Order getOrder() {
		return order;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setTotalPrice() {
		this.totalPrice=0.0;
		for (OrderLine ol : this.order.getOrderLines())
			this.totalPrice += ol.getPrice();
	}

}
