package be.jebouquine.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public abstract class GenericDAOImpl<T> {

	protected SessionFactory sessionFactory;

	public void add(T object) throws Exception {
		this.sessionFactory.getCurrentSession().persist(object);
	}

	public abstract void remove(T object);
	
	public abstract void modify(T object) throws Exception;
	
	@SuppressWarnings("unchecked")	
	public T findByID(Class<T> classType, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(classType, id);
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findAll(Class<T> t){
		return sessionFactory.getCurrentSession().createQuery("from " +  t.getName()).list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
