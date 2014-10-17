package be.jebouquine.controlers;

import java.util.List;

import be.jebouquine.business.interfaces.ICategoryBusiness;
import be.jebouquine.entities.Category;

public class FOHeaderAction {
	private ICategoryBusiness categoryBusiness;
	private List<Category> categories;
	
	
	public String execute(){
		setCategories(categoryBusiness.findAll());
		
		return "success";
	}
	
	public String lookCategory(){
		
		return "success";
	}

	public ICategoryBusiness getCategoryBusiness() {
		return categoryBusiness;
	}

	public void setCategoryBusiness(ICategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
