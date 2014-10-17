package be.jebouquine.business.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.interfaces.ICategoryBusiness;
import be.jebouquine.dao.interfaces.ICategoryDAO;
import be.jebouquine.entities.Category;

@Transactional(readOnly = false)
public class CategoryBusinessImpl implements ICategoryBusiness {

	private ICategoryDAO categoryDAO;

	// -------------------------------------------------------------------
	public ICategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(ICategoryDAO iCategoryDAO) {
		this.categoryDAO = iCategoryDAO;
	}

	// -------------------------------------------------------------------
	@Override
	public boolean add(Category category) {
		try {
			if(category.getName().length()>255)
				throw new Exception();
			category.setName(category.getName().trim());
			categoryDAO.add(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean remove(Category category) {
		try {
			categoryDAO.remove(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Category> findAll() {
		List<Category> categories = null;
		try {
			categories = categoryDAO.findAll();
			return categories;
		} catch (Exception e) {
			return categories;
		}
	}

	@Override
	public boolean modify(Category category) {
		try {
			if(category.getName().length()>255)
				throw new Exception();
			category.setName(category.getName().trim());
			categoryDAO.modify(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Category findByID(Integer id){
		Category category = null;
		try {
			category = categoryDAO.findByID(id);
			return category;
		} catch (Exception e) {
			return category;
		}
	}

	@Override
	public Category findByName(String name) {
		return categoryDAO.findByName(name);
	}
	
}
