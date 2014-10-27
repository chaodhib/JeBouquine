package be.jebouquine.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import be.jebouquine.business.criteria.CriteriaSearchBook;
import be.jebouquine.dao.interfaces.IBookDAO;
import be.jebouquine.entities.Book;

public class BookDAOImpl extends GenericDAOImpl<Book> implements IBookDAO {

	@Override
	public void add(Book object) throws Exception {
		super.add(object);
	}

	@Override
	public void modify(Book object) throws Exception {
		if(object.getId()==null)
			throw new Exception("The DAO needs a valid ID to modify an object");
		Book trueBook = findByID(object.getId());
		
		if(trueBook.equals(object))
			return;
		
		trueBook = setEverything(trueBook, object);
		this.sessionFactory.getCurrentSession().saveOrUpdate(trueBook);
	}

	// ------------------------------------------------
	// Set les champs du book managé avec les valeurs du book de la vue
	private Book setEverything(Book trueBook, Book object) {
		trueBook.setAuthor(object.getAuthor());
		trueBook.setIsAvailable(object.getIsAvailable());
		trueBook.setIsBestSales(object.getIsBestSales());
		trueBook.setIsNovelty(object.getIsNovelty());
		trueBook.setCategory(object.getCategory());
		trueBook.setComments(object.getComments());
		trueBook.setPublisher(object.getPublisher());
		trueBook.setIsbn(object.getIsbn());
		trueBook.setOrders(object.getOrders());
		trueBook.setPrice(object.getPrice());
		trueBook.setTitle(object.getTitle());
		trueBook.setYear(object.getYear());
		trueBook.setUrlImage(object.getUrlImage());
		trueBook.setUrlImageMini(object.getUrlImageMini());
		return trueBook;
	}

	@Override
	public void remove(Book object) {
		this.sessionFactory.getCurrentSession()
				.delete(findByID(object.getId()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see be.jebouquine.dao.imp.IBookDAO#findByID(java.io.Serializable)
	 */
	@Override
	public Book findByID(Serializable id) {
		return super.findByID(Book.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.jebouquine.dao.imp.IBookDAO#findByCriteria(be.jebouquine.criteria.
	 * CriteriaSearchBook)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Book> findByCriteria(CriteriaSearchBook searchCriteria) {

		if (null == searchCriteria)
			throw new IllegalArgumentException(
					"There is no searchCriteria, you must give one");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Book.class);

		if (null != searchCriteria.getIsbn()
				&& !searchCriteria.getIsbn().isEmpty()) {
			criteria.add(Restrictions.eq("isbn", searchCriteria.getIsbn()));
		}

		if (null != searchCriteria.getTitle()
				&& !searchCriteria.getTitle().isEmpty()) {
			criteria.add(Restrictions.ilike("title",
					"%" + searchCriteria.getTitle() + "%"));
		}

		if (null != searchCriteria.getAuthor()) {
			criteria.add(Restrictions.eq("author", searchCriteria.getAuthor()));
		}

		if (null != searchCriteria.getEditor()) {
			criteria.add(Restrictions.eq("publisher", searchCriteria.getEditor()));
		}

		if (null != searchCriteria.getCategory()) {
			criteria.add(Restrictions.eq("category",
					searchCriteria.getCategory()));
		}

		if (null != searchCriteria.getYear() && searchCriteria.getYear() != 0) {
			if (searchCriteria.getYear() > 0)
				criteria.add(Restrictions.eq("year", searchCriteria.getYear()));
		}

		return criteria.list();
	}

	public List<Book> findByKeywords(CriteriaSearchBook searchCriteria) {
		List<Book> results = null;
		if (null == searchCriteria)
			throw new IllegalArgumentException(
					"There is no searchCriteria, you must give one");

		if (!searchCriteria.getKeywords().isEmpty()) {
			List<String> keywords = searchCriteria.getKeywords();
			List<Book> resultsTemp = new ArrayList<Book>();

			for (String kw : keywords) {
				resultsTemp.addAll(querySearch(kw));
			}
			// On vire les doublons	
			Set<Book> set = new HashSet<Book>(resultsTemp);
			results = new ArrayList<Book>(set);
		}

		return results;
	}
	
	@SuppressWarnings("unchecked")
	private List<Book> querySearch(String keyword){
		String queryFrom = "from Book book ";
		String queryTitle = " where lower(book.title) like lower('%"+ keyword + "%')";		
		
		String queryAuthor = " or(lower(book.author.firstName) like lower('%"	+ keyword + "%'))"
				+ " or(lower(book.author.lastName) like lower('%"	+ keyword + "%')) ";
		
		String queryEditor = " or(lower(book.publisher.name) like lower('%"+ keyword + "%'))";
		
		String query = queryFrom + queryTitle + queryAuthor + queryEditor;
		return sessionFactory.getCurrentSession().createQuery(query).list();	
	}
	

	@SuppressWarnings("unchecked")
	public List<Book> findBestSales() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Book.class);
		
		return criteria.add(Restrictions.eq("isBestSales", true)).list();
	}

	@SuppressWarnings("unchecked")
	public List<Book> findNovelties() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Book.class);
		return criteria.add(Restrictions.eq("isNovelty", true)).list();
	}
}
