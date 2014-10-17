package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.business.criteria.CriteriaSearchAuthor;
import be.jebouquine.entities.Author;

public interface IAuthorBusiness {
	
	public boolean add(Author author);

	public boolean remove(Author author);

	public boolean modify(Author author);
	
	public List<Author> findAll();
	
	public Author findByID(Integer id);
	
	public List<Author> findByCriteria(CriteriaSearchAuthor criteria);
	
	
}
