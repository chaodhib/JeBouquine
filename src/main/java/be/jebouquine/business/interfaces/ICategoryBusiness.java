package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.entities.Category;

public interface ICategoryBusiness {
	public boolean add(Category category);

	public boolean remove(Category category);

	public List<Category> findAll();

	public boolean modify(Category category);
	
	public Category findByID(Integer id);

	public Category findByName(String name);
	
}
