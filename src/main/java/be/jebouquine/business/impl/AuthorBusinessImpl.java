package be.jebouquine.business.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.criteria.CriteriaSearchAuthor;
import be.jebouquine.business.interfaces.IAuthorBusiness;
import be.jebouquine.dao.interfaces.IAuthorDAO;
import be.jebouquine.entities.Author;


@Transactional(readOnly = false)
public class AuthorBusinessImpl implements IAuthorBusiness {
	private IAuthorDAO authorDAO;

	public IAuthorDAO getAuthorDAO() {
		return authorDAO;
	}

	public void setAuthorDAO(IAuthorDAO author) {
		this.authorDAO = author;
	}

	@Override
	public boolean add(Author author) {
		try {
			if(author.getFirstName().length()>255 || author.getLastName().length()>255)
				throw new Exception();
			author.setFirstName(author.getFirstName().trim());
			author.setLastName(author.getLastName().trim());
			authorDAO.add(author);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean remove(Author author) {
		try {
			authorDAO.remove(author);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean modify(Author author) {
		try {
			if(author.getFirstName().length()>255 || author.getLastName().length()>255)
				throw new Exception();
			author.setFirstName(author.getFirstName().trim());
			author.setLastName(author.getLastName().trim());
			authorDAO.modify(author);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Author> findAll() {
		List<Author> authors = null;
		try {
			authors = authorDAO.findAll();
			return authors;
		} catch (Exception e) {
			return authors;
		}
	}

	public Author findByID(Integer id){
		Author author = null;
		try {
			author = authorDAO.findByID(id);
			return author;
		} catch (Exception e) {
			return author;
		}
	}
	
	@Override
	public List<Author> findByCriteria(CriteriaSearchAuthor criteria) {
		List<Author> authors = null;
		try {
			if(criteria.getFirstName().length()>255 || criteria.getLastName().length()>255)
				throw new Exception();
			authors = authorDAO.findByCriteria(criteria);
			return authors;
		} catch (Exception e) {
			return null;
		}
	}

}
