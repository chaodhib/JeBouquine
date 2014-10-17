package be.jebouquine.business.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.criteria.CriteriaSearchClient;
import be.jebouquine.business.interfaces.IClientBusiness;
import be.jebouquine.dao.interfaces.IClientDAO;
import be.jebouquine.entities.Client;
import be.jebouquine.exceptions.JeBouquineLoginException;
import be.jebouquine.modelview.SessionAccount;

@Transactional(readOnly = false)
public class ClientBusinessImpl implements IClientBusiness {

	private IClientDAO clientDAO;

	// -------------------------------------------------------------------

	public IClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	// -------------------------------------------------------------------

	@Override
	public boolean add(Client client) throws Exception {
		// CHECK FOR EMAIL
		if (null == client.getEmail() || client.getEmail().isEmpty()) {
			throw new Exception("No email provided");
		} else {
			// CHECK IF ACCOUNT ALREADY EXISTS
			CriteriaSearchClient searchClient = new CriteriaSearchClient();
			searchClient.setEmail(client.getEmail());
			if (clientDAO.findByCriteria(searchClient).size() > 0) {
				throw new Exception(
						"Somebody is already registered with this Email");
			}
		}

		// CHECK FOR LOGIN
		if (null == client.getLogin() || client.getLogin().isEmpty()) {
			throw new Exception("No Login provided");
		} else {
			// CHECK IF ACCOUNT ALREADY EXISTS
			CriteriaSearchClient searchClient = new CriteriaSearchClient();
			searchClient.setLogin(client.getLogin());
			if (clientDAO.findByCriteria(searchClient).size() > 0) {
				throw new Exception(
						"Somebody is already registered with this Login");
			}
		}

		// CHECK FOR PASSWORD
		if (null == client.getPassword() || client.getPassword().isEmpty()) {
			throw new Exception("No password provided");
		}

		try {
			clientDAO.add(client);
			return true;
		} catch (Exception e) {
			throw e;
			// return false;
		}
	}

	@Override
	public boolean remove(Client client) {
		try {
			clientDAO.remove(client);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Client> findByCriteria(CriteriaSearchClient searchClient) {
		return clientDAO.findByCriteria(searchClient);
	}

	@Override
	public boolean modify(Client client) throws Exception {
		// CHECK IF EMAIL AlREADY USED
		if (null != client.getEmail()) {
			CriteriaSearchClient searchClient = new CriteriaSearchClient();
			searchClient.setEmail(client.getEmail());
			List<Client> results = clientDAO.findByCriteria(searchClient);

			for (Client cl : results) {
				if (cl.getEmail().equals(client.getEmail())
						&& !cl.getId().equals(cl.getId())) {
					throw new Exception(
							"Somebody is already registered with this Email");
				}
			}
		}
		try {
			clientDAO.modify(client);
			System.out.println("le DAO a fait l'update");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Si utilisateur trouvé, renvoie une SessionAccount avec le nom et l'id du
	 * client dans la BDD Si l'utilisateur n'est pas trouvé, renvoie une
	 * exception Si la paire login/mdp n'est pas trouvé, renvoie une exception
	 * 
	 * @throws Exception
	 */
	@Override
	public SessionAccount login(String username, String password)
			throws Exception {
		SessionAccount sessionAccount = new SessionAccount();
		CriteriaSearchClient searchClient = new CriteriaSearchClient();
		searchClient.setLogin(username);
		List<Client> user = null;
		try { // si jamais il y a une erreur
			user = clientDAO.findByCriteria(searchClient);
		} catch (Exception e) {
			throw e;
		}

		if (null == user || user.size() == 0)
			throw new JeBouquineLoginException("Business : le compte n'a pas été trouvé");

		if (!user.get(0).getPassword().equals(password))
			throw new JeBouquineLoginException(
					"Business : le mot de passe ne correspond pas au login");

		sessionAccount.setId(user.get(0).getId());
		sessionAccount.setName(user.get(0).getFirstName() + " "
				+ user.get(0).getLastName());

		return sessionAccount;
	}

	@Override
	public Client findByID(Integer id) {
		Client client = null;
		try {
			client = clientDAO.findByID(id);
			return client;
		} catch (Exception e) {
			throw e;
		}
	}
}
