package be.jebouquine.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import be.jebouquine.dao.interfaces.IGlobalParamDAO;
import be.jebouquine.entities.GlobalParam;
import be.jebouquine.exceptions.JeBouquineException;

public class GlobalParamDAOImpl extends GenericDAOImpl<GlobalParam> implements
		IGlobalParamDAO {

	public GlobalParam findByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				GlobalParam.class);
		if (null != name && !name.isEmpty()) {
			criteria.add(Restrictions.eq("name", name));
			if(!criteria.list().isEmpty())
				return (GlobalParam) criteria.list().get(0); // on presume qu'il y ait au plus un seul param par nom
			else
				return null;
		} else {
			throw new IllegalArgumentException(); //TODO : mettre au clair la strategie de gestion des exceptions
		}
	}

	public void save(GlobalParam globparam) throws Exception {
		if (null == findByName(globparam.getName()))
			super.add(globparam);
		else {
			this.sessionFactory.getCurrentSession().update(globparam);
		}

	}

	@Override
	public void remove(GlobalParam object) {
		this.sessionFactory.getCurrentSession().delete(
				findByName(object.getName()));

	}

	@Override
	public void modify(GlobalParam object) throws Exception {
		if(object.getId()==null)
			throw new Exception("The DAO needs a valid ID to modify an object");

		GlobalParam trueGP = findByID(GlobalParam.class, object.getId());
		trueGP.setName(object.getName());
		trueGP.setValue(object.getValue());
		this.sessionFactory.getCurrentSession().saveOrUpdate(trueGP);
	}
}
