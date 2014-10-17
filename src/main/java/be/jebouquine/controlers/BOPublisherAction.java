package be.jebouquine.controlers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.jebouquine.business.interfaces.IEditorBusiness;
import be.jebouquine.entities.Editor;

public class BOPublisherAction {
	// Param utilisés par plusieurs actions
	private IEditorBusiness publisherBusiness;
	private Editor publisher;

	// METHOD ACTION 1
	public String add() {
		if(publisherBusiness.add(publisher))
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
		
		publisher=publisherBusiness.findByID(ID);// mon controleur va peupler l'objet publisher qui sera disponible pour la page suivant si c'est un modif
		if(value[0].equals("Modifier"))
		{
			return "modif";
		}
		else if(value[0].equals("Supprimer")){
			try {
				publisherBusiness.remove(publisher);
			} catch (Exception e) {
				return "error";
			}
			return "suppr";
		}
		else
			return null;
	}

	// METHOD ACTION 3
	private List<Editor> publishers;
	private int sizeOfList;

	public String displayAll() throws Exception {
		publishers = publisherBusiness.findAll();
		setSizeOfList(publishers.size());

		return "success";
	}

	// METHOD ACTION 4
	public String modify() {
		if(publisherBusiness.modify(publisher))
			return "success";
		else
			return "error";
	}

	// GETTERS - SETTERS
	public IEditorBusiness getPublisherBusiness() {
		return publisherBusiness;
	}

	public void setPublisherBusiness(IEditorBusiness publisherBusiness) {
		this.publisherBusiness = publisherBusiness;
	}

	public Editor getPublisher() {
		return publisher;
	}

	public void setPublisher(Editor publisher) {
		this.publisher = publisher;
	}

	public Map<String, String[]> getModifMap() {
		return modifMap;
	}

	public void setModifMap(Map<String, String[]> modifMap) {
		this.modifMap = modifMap;
	}

	public List<Editor> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Editor> publishers) {
		this.publishers = publishers;
	}

	public int getSizeOfList() {
		return sizeOfList;
	}

	public void setSizeOfList(int sizeOfList) {
		this.sizeOfList = sizeOfList;
	}

}
