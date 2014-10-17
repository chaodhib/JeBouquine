package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.entities.Client;
import be.jebouquine.entities.Order;
import be.jebouquine.modelview.OrderView;

public interface IOrderBusiness {

	public OrderView findById();
	
	/** TODO: by reference to object client or by clientId
	 * 
	 * @param client
	 * @return
	 */
	public List<OrderView>  findByClient(Client client);
}
