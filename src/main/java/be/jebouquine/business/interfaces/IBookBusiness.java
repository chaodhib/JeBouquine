package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.business.criteria.CriteriaSearchBook;
import be.jebouquine.entities.Book;

public interface IBookBusiness {
	public boolean add(Book book);

	public boolean remove(Book book);

	public boolean modify(Book book);
	
	public List<Book> findByCriteria(CriteriaSearchBook criteria);
	
	public List<Book> findByKeywords(String keywords);
	
	public Book findByID(Integer id);
	
	public List<Book> bestSales();
	
	public List<Book> novelties();
	
	public boolean addComment(Book book,String comment);

}
