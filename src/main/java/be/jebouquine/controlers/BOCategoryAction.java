package be.jebouquine.controlers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.jebouquine.business.interfaces.ICategoryBusiness;
import be.jebouquine.entities.Category;

public class BOCategoryAction {
	// Param utilisés par plusieurs actions
	private ICategoryBusiness categoryBusiness;
	private Category category;

	// METHOD ACTION 1
	public String add() {
		if(categoryBusiness.add(category))
			return "success";
		else
			return "error";
	}

	// METHOD ACTION 2 celle ci preremplit le champs qui va permettre de modifier le nom d'une categorie/auteur/editeur/...
	private Map<String, String[]> modifMap=new HashMap<String, String[]>();
	
	public String preModifOrSuppr() {
		
		String[] modif= modifMap.keySet().toArray(new String[0]); // recupere le set key (de String) de la map sous forme d'array de String en les castant
		Integer ID=Integer.parseInt(modif[0]); // dans le set key de la map, il n'y a qu'un element, l'id de la categorie/auteur/etc.. correspodant à celui choisi pour la modification/supression
		
		String[] value=(String[]) modifMap.get(modif[0]); // recupere la value associé à la key modif[0] qui est un array de String de dimension 1
		
		category=categoryBusiness.findByID(ID);// mon controleur va peupler l'objet category qui sera disponible pour la page suivant si c'est un modif
		if(value[0].equals("Modifier"))
		{
			return "modif";
		}
		else if(value[0].equals("Supprimer")){
			try {
				categoryBusiness.remove(category);
			} catch (Exception e) {
				return "error";
			}
			return "suppr";
		}
		else
			return null;
	}

	// METHOD ACTION 3
	private List<Category> categories;
	private int sizeOfList;

	public String displayAll() throws Exception {
		categories = categoryBusiness.findAll();
		sizeOfList=categories.size();

		return "success";
	}

	// METHOD ACTION 4
	public String modify() {
		if(categoryBusiness.modify(category))
			return "success";
		else
			return "error";
	}

	// GETTERS - SETTERS
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Map<String, String[]> getModifMap() {
		return modifMap;
	}

	public void setModifMap(Map<String, String[]> modifMap) {
		this.modifMap = modifMap;
	}

	public ICategoryBusiness getCategoryBusiness() {
		return categoryBusiness;
	}

	public void setCategoryBusiness(ICategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
	}

	public int getSizeOfList() {
		return sizeOfList;
	}

	public void setSizeOfList(int sizeOfList) {
		this.sizeOfList = sizeOfList;
	}

}
