package be.jebouquine.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import be.jebouquine.business.criteria.CriteriaSearchClient;
import be.jebouquine.entities.Client;

public interface IClientDAO extends IGenericDAO<Client> {

	public List<Client> findByCriteria(CriteriaSearchClient searchCriteria);
	public Client findByID(Serializable id);
	
}
