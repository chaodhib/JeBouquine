package be.jebouquine.dao.impl;

import be.jebouquine.dao.interfaces.IOrderDAO;
import be.jebouquine.entities.Order;
import be.jebouquine.exceptions.JeBouquineException;

public class OrderDAOImpl extends GenericDAOImpl<Order> implements IOrderDAO {

	@Override
	public void add(Order object) throws Exception{
		
		
		if(object.getOrderLines().size() == 0)
			throw new JeBouquineException("DAO: no lines in the order");
	
		if(null == object.getClient())
			throw new JeBouquineException("DAO: no client associated to the order");
		
		if(null == object.getAddress() || object.getAddress().isEmpty())
			throw new JeBouquineException("DAO: no adress of delivery associated to the order");
		
		if(null == object.getDate())
			throw new JeBouquineException("DAO: no date associated to the order");
		
//		if(null == object.getOrderState() || object.getOrderState().getName().isEmpty())
//			throw new JeBouquineException("DAO: no order state associated to the order");
			
		super.add(object);
	}
	
	@Override
	public void remove(Order object) {
		Order trueOrder = findByID(object.getId());
		this.sessionFactory.getCurrentSession().delete(trueOrder);
	}

	@Override
	public void modify(Order object) throws Exception {
		Order order = findByID(object.getId());
		
		if(order.equals(object))
			return;
		
		order = setEverything(order, object);
		this.sessionFactory.getCurrentSession().saveOrUpdate(order);

	}
	
	
	private Order setEverything(Order newOrder, Order oldOrder){
		if(!(oldOrder.getOrderLines().size() == 0))
			newOrder.setOrderLines(oldOrder.getOrderLines());
		if(null != oldOrder.getClient())
			newOrder.setClient(oldOrder.getClient());
		if(null != oldOrder.getAddress() && !oldOrder.getAddress().isEmpty())
			newOrder.setAddress(oldOrder.getAddress());
		if(null != oldOrder.getDate())
			newOrder.setDate(oldOrder.getDate());
		if(null != oldOrder.getOrderState())
			newOrder.setOrderState(oldOrder.getOrderState());
		return newOrder;
	}
	
	
	public Order findByID(Integer id) {
		return (Order) super.findByID(Order.class, id);
	}


	
}
