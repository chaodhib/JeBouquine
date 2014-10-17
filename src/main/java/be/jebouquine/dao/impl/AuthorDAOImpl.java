package be.jebouquine.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import be.jebouquine.business.criteria.CriteriaSearchAuthor;
import be.jebouquine.dao.interfaces.IAuthorDAO;
import be.jebouquine.entities.Author;

public class AuthorDAOImpl extends GenericDAOImpl<Author> implements IAuthorDAO {

	@Override
	public void add(Author object) throws Exception {
		CriteriaSearchAuthor crit = new CriteriaSearchAuthor();
		crit.setFirstName(object.getFirstName());
		crit.setLastName(object.getLastName());

		if (!findByCriteria(crit).isEmpty())
			throw new Exception("This Author Already Exists");

		if (null != object
				&& !(object.getFirstName().isEmpty() && object.getLastName()
						.isEmpty()))
			super.add(object);
	}

	@Override
	public void remove(Author object) {
		Author trueAuthor = findByID(object.getId());
		this.sessionFactory.getCurrentSession().delete(trueAuthor);
	}

	@Override
	public void modify(Author object) throws Exception {
		Author auth = findByID(object.getId());
		
		if(auth.equals(object)) 
			return;
		
		CriteriaSearchAuthor crit = new CriteriaSearchAuthor();
		crit.setFirstName(object.getFirstName());
		crit.setLastName(object.getLastName());
		
		List<Author> auths = findByCriteria(crit);
		for(Author atr: auths)
			if(atr != auth)
			throw new Exception("This Author Already Exists");
	
		auth.setFirstName(object.getFirstName());
		auth.setLastName(object.getLastName());
		this.sessionFactory.getCurrentSession().saveOrUpdate(auth);
	}

	@Override
	public List<Author> findAll() {
		return super.findAll(Author.class);
	}

	@Override
	public Author findByID(Serializable id) {
		return super.findByID(Author.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	// Doit renvoyer une List car createQuery().list() renvoie une liste
	public List<Author> findByCriteria(CriteriaSearchAuthor name) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Author.class);

		if (!name.getFirstName().isEmpty()) {
			criteria.add(Restrictions.eq("firstName", name.getFirstName()));
		}
		if (!name.getLastName().isEmpty()) {
			criteria.add(Restrictions.eq("lastName", name.getLastName()));
		}
		return criteria.list();
	}

}
