package be.jebouquine.controlers;

import be.jebouquine.business.singletons.OrderBusinessSingleton;
import be.jebouquine.entities.GlobalParam;

import com.opensymphony.xwork2.Action;

public class TestAction implements Action {
	private OrderBusinessSingleton orderBusinessSingleton;
	
	private GlobalParam param;

	@Override
	public String execute() throws Exception {
		try {
			System.out.println("TestAction, println: "+orderBusinessSingleton.getNextOrderNumber());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}

	public GlobalParam getParam() {
		return param;
	}

	public void setParam(GlobalParam param) {
		this.param = param;
	}

	public OrderBusinessSingleton getOrderBusinessSingleton() {
		return orderBusinessSingleton;
	}

	public void setOrderBusinessSingleton(OrderBusinessSingleton orderBusinessSingleton) {
		this.orderBusinessSingleton = orderBusinessSingleton;
	}

}
