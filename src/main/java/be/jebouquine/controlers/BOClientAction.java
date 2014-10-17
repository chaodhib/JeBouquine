package be.jebouquine.controlers;

import be.jebouquine.business.interfaces.IClientBusiness;
import be.jebouquine.entities.Client;

public class BOClientAction {
		//TODO BO client n'est pas fait
	private Client client;
	private IClientBusiness clientBusiness;
	private String checkPassword;
	
	public String editAccount() {
		try {
			if (!client.getPassword().equals(checkPassword))
				return "error";
			boolean modif = clientBusiness.modify(client);
			if (!modif) {
				return "error";
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}

	}



	// ---------------------------
	// -----GETTERS - SETTERS-----
	// ---------------------------


	public final Client getClient() {
		return client;
	}

	public final void setClient(Client client) {
		this.client = client;
	}

	public final IClientBusiness getClientBusiness() {
		return clientBusiness;
	}

	public final void setClientBusiness(IClientBusiness clientBusiness) {
		this.clientBusiness = clientBusiness;
	}

	public final String getCheckPassword() {
		return checkPassword;
	}

	public final void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
}
