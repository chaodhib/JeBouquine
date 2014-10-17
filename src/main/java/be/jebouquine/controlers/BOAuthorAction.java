package be.jebouquine.controlers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.jebouquine.business.criteria.CriteriaSearchAuthor;
import be.jebouquine.business.interfaces.IAuthorBusiness;
import be.jebouquine.entities.Author;

public class BOAuthorAction {
	// Param utilisés par plusieurs actions
	private IAuthorBusiness authorBusiness;
	private Author author;

	// METHOD ACTION 1
	public String add() {
		if(authorBusiness.add(author))
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
		
		author=authorBusiness.findByID(ID);// mon controleur va peupler l'objet author qui sera disponible pour la page suivant si c'est un modif
		if(value[0].equals("Modifier"))
		{
			return "modif";
		}
		else if(value[0].equals("Supprimer")){
			authorBusiness.remove(author);
			return "suppr";
		}
		else
			return null;
	}

	// METHOD ACTION 3
	private List<Author> authors;
	private CriteriaSearchAuthor searchAuthor;
	private int numberOfResult;
	
	public String findByCriteria() throws Exception {
		authors=authorBusiness.findByCriteria(searchAuthor);
		numberOfResult=authors.size();

		return "success";
	}

	// METHOD ACTION 4
	public String modify() {
		if(authorBusiness.modify(author))
			return "success";
		else
			return "error";
}

	// GETTERS - SETTERS
	public IAuthorBusiness getAuthorBusiness() {
		return authorBusiness;
	}

	public void setAuthorBusiness(IAuthorBusiness authorBusiness) {
		this.authorBusiness = authorBusiness;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Map<String, String[]> getModifMap() {
		return modifMap;
	}

	public void setModifMap(Map<String, String[]> modifMap) {
		this.modifMap = modifMap;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public CriteriaSearchAuthor getSearchAuthor() {
		return searchAuthor;
	}

	public void setSearchAuthor(CriteriaSearchAuthor searchAuthor) {
		this.searchAuthor = searchAuthor;
	}

	public int getNumberOfResult() {
		return numberOfResult;
	}

	public void setNumberOfResult(int numberOfResult) {
		this.numberOfResult = numberOfResult;
	}
	
	
}
