package be.jebouquine.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.jebouquine.dao.interfaces.IAdminDAO;
import be.jebouquine.entities.Admin;

public class AdminDAOImpl extends GenericDAOImpl<Admin> implements IAdminDAO {

	@Override
	public void add(Admin object) throws Exception {
		super.add(object);
	}

	@Override
	public void remove(Admin object) {
		Admin trueAdmin = findByID(object.getId());
		this.sessionFactory.getCurrentSession().delete(trueAdmin);
	}

	@Override
	public void modify(Admin object) {
		//TODO pas fini!
		Admin trueAdmin = findByID(object.getId());
		trueAdmin.setFirstName(object.getFirstName());
		this.sessionFactory.getCurrentSession().saveOrUpdate(trueAdmin);
	}
	
	public List<Admin> findAll() {
		return super.findAll(Admin.class);
	}
	
	public Admin findByID(Serializable id) {
		return super.findByID(Admin.class, id);
	}

	public List<Admin> findByCriteria(Class<Admin> typeClass, Serializable id){
		//TODO findByCriteria
		List<Admin> vide = new ArrayList<Admin>();
		return vide;
	}
	
	
}
