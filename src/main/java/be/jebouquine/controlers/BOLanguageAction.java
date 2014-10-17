package be.jebouquine.controlers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.jebouquine.business.interfaces.ILanguageBusiness;
import be.jebouquine.entities.Language;

public class BOLanguageAction {
	// Param utilisés par plusieurs actions
	private ILanguageBusiness languageBusiness;
	private Language language;

	// METHOD ACTION 1
	public String add() {
		if(languageBusiness.add(language))
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
		
		language=languageBusiness.findByID(ID);// mon controleur va peupler l'objet language qui sera disponible pour la page suivant si c'est un modif
		if(value[0].equals("Modifier"))
		{
			return "modif";
		}
		else if(value[0].equals("Supprimer")){
			try {
				languageBusiness.remove(language);
			} catch (Exception e) {
				return "error";
			}
			
			return "suppr";
		}
		else
			return null;
	}

	// METHOD ACTION 3
	private List<Language> languages;
	private int sizeOfList;

	public String displayAll() throws Exception {
		languages = languageBusiness.findAll();
		setSizeOfList(languages.size());
		
		return "success";
	}

	// METHOD ACTION 4
	public String modify() {
		if(languageBusiness.modify(language))
			return "success";
		else
			return "error";
	}

	// GETTERS - SETTERS
	public ILanguageBusiness getLanguageBusiness() {
		return languageBusiness;
	}

	public void setLanguageBusiness(ILanguageBusiness languageBusiness) {
		this.languageBusiness = languageBusiness;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Map<String, String[]> getModifMap() {
		return modifMap;
	}

	public void setModifMap(Map<String, String[]> modifMap) {
		this.modifMap = modifMap;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public int getSizeOfList() {
		return sizeOfList;
	}

	public void setSizeOfList(int sizeOfList) {
		this.sizeOfList = sizeOfList;
	}

}
