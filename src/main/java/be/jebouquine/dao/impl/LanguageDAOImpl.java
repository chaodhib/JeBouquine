package be.jebouquine.dao.impl;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.dao.interfaces.ILanguageDAO;
import be.jebouquine.entities.Language;


public class LanguageDAOImpl extends GenericDAOImpl<Language> implements ILanguageDAO{

	@Override
	public void add(Language language) throws Exception {
		if (null == language)
			throw new NullPointerException();
		if (findByName(language.getName())!=null)
			throw new Exception("The Language Already Exists");
		if (!language.getName().isEmpty())
			super.add(language);
	}

	@Override
	public void remove(Language language) {
		Language trueLanguage = findByID(language.getId());
		this.sessionFactory.getCurrentSession().delete(trueLanguage);
	}

	@Override
	public void modify(Language language) throws Exception {
		Language lan = findByID(language.getId());
		//Cas où la personne n'a rien changé
		if (lan.equals(language))
			return;
			
		// Check d'un éventuel conflit au niveau des noms
		if(findByName(language.getName())!=null && lan!=findByName(language.getName()))
				throw new Exception("The Category Already Exists");

		lan.setName(language.getName());
		this.sessionFactory.getCurrentSession().saveOrUpdate(lan);
	}

	public List<Language> findAll() {
		return super.findAll(Language.class);
	}
	
	public Language findByID(Serializable id) {
		return super.findByID(Language.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Language findByName(String name){
		List<Language> list=sessionFactory.getCurrentSession()
				.createQuery("from Language where name ='" + name +"'").list();
		if(list.size()==1)
			return list.get(0);
		else if(list.size()==0)
			return null;
		else
			throw new RuntimeException("Doublon dans les langues");
	}
}
