package be.jebouquine.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.criteria.CriteriaSearchBook;
import be.jebouquine.business.interfaces.IBookBusiness;
import be.jebouquine.dao.interfaces.IBookDAO;
import be.jebouquine.entities.Book;
import be.jebouquine.exceptions.JB_Business_ValidationException;

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
			if(!validationBook(book))
				throw new JB_Business_ValidationException();
			bookDAO.add(book);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean modify(Book book) {
		try {
			if(!validationBook(book))
				throw new JB_Business_ValidationException();
			bookDAO.modify(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param book
	 * @return true if the validation succeeded. False if not
	 */
	private boolean validationBook(Book book){
		if(book.getTitle()==null || book.getTitle().isEmpty())
			return false;
		
		if(book.getAuthor()==null||book.getCategory()==null||book.getPublisher()==null)
			return false;
		
		if(book.getIsbn()==null || book.getIsbn().isEmpty())
			return false;
		
		if(book.getYear()==null || book.getYear()>9999 || book.getYear()<0)
			return false;
		
		if(book.getPrice()==null || book.getPrice()<0.0)
			return false;
		
		if(book.getUrlImage()==null|| book.getUrlImage().isEmpty())
			book.setUrlImage("http://i.imgur.com/lw87NbB.png?1"); // image "No Image Available"
		
		if(book.getUrlImageMini()==null|| book.getUrlImageMini().isEmpty())
			book.setUrlImageMini("http://i.imgur.com/lw87NbB.png?1");
		
		if(book.getTitle().length()>255 
				|| book.getIsbn().length()>255 
				|| book.getUrlImage().length()>255 
				|| book.getUrlImageMini().length()>255)
			return false;
		return true;
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
