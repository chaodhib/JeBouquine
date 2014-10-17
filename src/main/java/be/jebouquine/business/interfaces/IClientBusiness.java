package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.business.criteria.CriteriaSearchClient;
import be.jebouquine.entities.Client;
import be.jebouquine.modelview.SessionAccount;

public interface IClientBusiness {
	public boolean add(Client client) throws Exception;

	public boolean remove(Client client);

	public List<Client> findByCriteria(CriteriaSearchClient searchClient);

	boolean modify(Client client) throws Exception;

	/**
	 * Validate the match between log & pass and return corresponding SessionAccount associated with the ClientAccount
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	SessionAccount login(String username, String password) throws Exception;

	Client findByID(Integer id);
	
}
