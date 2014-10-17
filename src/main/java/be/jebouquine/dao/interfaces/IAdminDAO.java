package be.jebouquine.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.entities.Admin;

public interface IAdminDAO extends IGenericDAO<Admin> {
	
	public abstract List<Admin> findAll();
	
	public abstract Admin findByID(Serializable id);
	
	public abstract List<Admin> findByCriteria(Class<Admin> typeClass, Serializable id);
}
