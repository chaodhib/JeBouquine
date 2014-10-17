package be.jebouquine.dao.impl;

import be.jebouquine.dao.interfaces.IOrderStateDAO;
import be.jebouquine.entities.OrderState;

public class OrderStateDAOImpl extends GenericDAOImpl<OrderState> implements IOrderStateDAO{


		
		
		
		public OrderState findByID(Integer id){
			return super.findByID(OrderState.class, id);
		}

		@Override
		public void remove(OrderState object) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void modify(OrderState object) throws Exception {
			// TODO Auto-generated method stub
			
		}

}
