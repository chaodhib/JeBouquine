package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.entities.Language;

public interface ILanguageBusiness {
	public boolean add(Language author);

	public boolean remove(Language author);

	public boolean modify(Language language);
	
	public List<Language> findAll();

	public Language findByID(Integer id);
	
	public Language findByName(String name);
}
