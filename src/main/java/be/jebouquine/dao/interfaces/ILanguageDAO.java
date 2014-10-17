package be.jebouquine.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.entities.Language;

public interface ILanguageDAO extends IGenericDAO<Language>{

	public List<Language> findAll();

	public Language findByID(Serializable id);
	
	public Language findByName(String name);

}