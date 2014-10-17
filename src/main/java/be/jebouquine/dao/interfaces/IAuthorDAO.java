package be.jebouquine.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.business.criteria.CriteriaSearchAuthor;
import be.jebouquine.entities.Author;

public interface IAuthorDAO extends IGenericDAO<Author>{

	public List<Author> findAll();

	public Author findByID(Serializable id);

	public List<Author> findByCriteria(CriteriaSearchAuthor name);

}
