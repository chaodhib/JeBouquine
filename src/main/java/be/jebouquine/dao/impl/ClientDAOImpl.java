package be.jebouquine.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import be.jebouquine.business.criteria.CriteriaSearchClient;
import be.jebouquine.dao.interfaces.IClientDAO;
import be.jebouquine.entities.Client;

public class ClientDAOImpl extends GenericDAOImpl<Client> implements IClientDAO {

	@Override
	public void add(Client object) throws Exception {
		super.add(object);
	}

	@Override
	public void modify(Client object) throws Exception {
		Client trueClient = findByID(object.getId());
		trueClient = setEverything(trueClient, object);
		this.sessionFactory.getCurrentSession().saveOrUpdate(trueClient);
	}

	// ------------------------------------------------
	// Set les champs du book managé avec les valeurs du book de la vue
	private Client setEverything(Client trueClient, Client object) {
		if (null != object.getAdress())
			trueClient.setAdress(object.getAdress());
		if (null != object.getBirthdate())
			trueClient.setBirthdate(object.getBirthdate());
		if (null != object.getFirstName() && !object.getFirstName().isEmpty())
			trueClient.setFirstName(object.getFirstName());
		if (null != object.getLastName() && !object.getLastName().isEmpty())
			trueClient.setLastName(object.getLastName());
		if (null != object.getEmail() && !object.getEmail().isEmpty())
			trueClient.setEmail(object.getEmail());
		if (null != object.getPassword() && !object.getPassword().isEmpty())
			trueClient.setPassword(object.getPassword());
		if (null != object.getPhoneNumber())
			trueClient.setPhoneNumber(object.getPhoneNumber());
		return trueClient;
	}

	@Override
	public void remove(Client object) {
		this.sessionFactory.getCurrentSession()
				.delete(findByID(object.getId()));
	}

	@Override
	public Client findByID(Serializable id) {
		return super.findByID(Client.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> findByCriteria(CriteriaSearchClient searchCriteria) {

		if (null == searchCriteria)
			throw new IllegalArgumentException(
					"There is no searchCriteria, you must give one");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Client.class);

		if (null != searchCriteria.getFirstName()
				&& !searchCriteria.getFirstName().isEmpty()) {
			criteria.add(Restrictions.eq("firstName",
					searchCriteria.getFirstName()));
		}

		if (null != searchCriteria.getLastName()
				&& !searchCriteria.getLastName().isEmpty()) {
			criteria.add(Restrictions.eq("lastName",
					searchCriteria.getLastName()));
		}

		if (null != searchCriteria.getLogin()
				&& !searchCriteria.getLogin().isEmpty()) {
			criteria.add(Restrictions.eq("login", searchCriteria.getLogin()));
		}

		if (null != searchCriteria.getEmail()
				&& !searchCriteria.getEmail().isEmpty()) {
			criteria.add(Restrictions.eq("email", searchCriteria.getEmail()));
		}

		return criteria.list();
	}

}
