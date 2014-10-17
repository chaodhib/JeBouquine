package be.jebouquine.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import be.jebouquine.dao.interfaces.IGlobalParamDAO;
import be.jebouquine.entities.GlobalParam;
import be.jebouquine.exceptions.JeBouquineBusinessException;
import be.jebouquine.exceptions.JeBouquineException;

public class GlobalParamDAOImpl extends GenericDAOImpl<GlobalParam> implements
		IGlobalParamDAO {

	public GlobalParam findByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				GlobalParam.class);
		if (null != name && !name.isEmpty()) {
			criteria.add(Restrictions.eq("name", name));
			return (GlobalParam) criteria.list().get(0);
		} else {
			return null;
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
		if (null == object.getName() || object.getName().isEmpty())
			throw new JeBouquineException(
					"DAO : le nom d'un paramètre global ne peut être vide");

		GlobalParam trueGP = findByName(object.getName());
		trueGP.setName(object.getName());
		trueGP.setValue(object.getValue());
		this.sessionFactory.getCurrentSession().saveOrUpdate(trueGP);
	}
}