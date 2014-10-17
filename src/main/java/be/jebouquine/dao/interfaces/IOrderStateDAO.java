package be.jebouquine.dao.interfaces;

import be.jebouquine.entities.OrderState;

public interface IOrderStateDAO {

	public abstract OrderState findByID(Integer id);

}