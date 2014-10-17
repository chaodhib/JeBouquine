package be.jebouquine.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.entities.Editor;

public interface IEditorDAO extends IGenericDAO<Editor> {

	public List<Editor> findAll();

	public Editor findByID(Serializable id);
	
	public Editor findByName(String name);

}