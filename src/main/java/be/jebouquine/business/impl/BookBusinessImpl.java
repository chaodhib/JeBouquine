package be.jebouquine.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.criteria.CriteriaSearchBook;
import be.jebouquine.business.interfaces.IBookBusiness;
import be.jebouquine.dao.interfaces.IBookDAO;
import be.jebouquine.entities.Book;

@Transactional(readOnly= false)
public class BookBusinessImpl implements IBookBusiness {

	
	private IBookDAO bookDAO;
	
	private final int SIZEOFBESTSALES = 5;
	private final int SIZEOFNOVELTIES = 5;
	
	// -------------------------------------------------------------------
	
	public IBookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	// -------------------------------------------------------------------

	@Override
	public boolean add(Book book) {
		try {
			bookDAO.add(book);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean remove(Book book) {
		try {
			bookDAO.remove(book);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean modify(Book book) {
		try {
			bookDAO.modify(book);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Book> findByCriteria(CriteriaSearchBook criteria) {
		List<Book> books;
		try {
			books = bookDAO.findByCriteria(criteria);
			return books;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Book> findByKeywords(String keywords) {
		CriteriaSearchBook crit = new CriteriaSearchBook();
		List<String> keywordsList= new ArrayList<String>();
		String[] keywordsArray = keywords.split("\\s");  

		for(String kw: keywordsArray){
			keywordsList.add(kw);
		}
		
		crit.setKeywords(keywordsList);
		
		return bookDAO.findByKeywords(crit);
	}

	@Override
	public Book findByID(Integer id) {
		Book book = null;
		try {
			book = bookDAO.findByID(id);
			return book;
		} catch (Exception e) {
			return book;
		}
	}
		
	@Override
	public List<Book> bestSales() {
		List<Book> books = null;
		try {
			books = bookDAO.findBestSales();
			return books.subList(0, SIZEOFBESTSALES);
		} catch (Exception e) {
			return books;
		}
	}

	@Override
	public List<Book> novelties() {
		List<Book> books = null;
		try {
			books = bookDAO.findNovelties();
			return books.subList(0, SIZEOFNOVELTIES);
		} catch (Exception e) {
			return books;
		}
	}

}
