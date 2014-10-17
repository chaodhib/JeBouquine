package be.jebouquine.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.business.criteria.CriteriaSearchBook;
import be.jebouquine.entities.Book;

public interface IBookDAO extends IGenericDAO<Book> {

	public abstract Book findByID(Serializable id);

	public abstract List<Book> findByCriteria(CriteriaSearchBook searchCriteria);
	
	public abstract List<Book> findByKeywords(CriteriaSearchBook crit);
	
	public abstract List<Book> findBestSales();
	
	public abstract List<Book> findNovelties();
}