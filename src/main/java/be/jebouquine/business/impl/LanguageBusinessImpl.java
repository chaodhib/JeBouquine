package be.jebouquine.business.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.interfaces.ILanguageBusiness;
import be.jebouquine.dao.interfaces.ILanguageDAO;
import be.jebouquine.entities.Language;

@Transactional(readOnly = false)
public class LanguageBusinessImpl implements ILanguageBusiness {
	private ILanguageDAO languageDAO;

	// -------------------------------------------------------------------
	public ILanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(ILanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}
	// -------------------------------------------------------------------
	
	@Override
	public boolean add(Language language) {
		try {
			if(language.getName().length()>255)
				throw new Exception();
			language.setName(language.getName().trim());
			languageDAO.add(language);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean remove(Language language) {
		try {
			languageDAO.remove(language);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean modify(Language language) {
		try {
			if(language.getName().length()>255)
				throw new Exception();
			language.setName(language.getName().trim());
			languageDAO.modify(language);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Language> findAll() {
		List<Language> languages = null;
		try {
			languages = languageDAO.findAll();
			return languages;
		} catch (Exception e) {
			return languages;
		}
	}

	public Language findByID(Integer id) {
		Language language = null;
		try {
			language = languageDAO.findByID(id);
			return language;
		} catch (Exception e) {
			return language;
		}
	}

	@Override
	public Language findByName(String name) {
		return languageDAO.findByName(name);
	}

}
