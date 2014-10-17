package be.jebouquine.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.entities.Category;

public interface ICategoryDAO extends IGenericDAO<Category>{

	public List<Category> findAll();

	public Category findByID(Serializable id);
	
	public Category findByName(String name);
}