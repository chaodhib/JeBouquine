package be.jebouquine.controlers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import be.jebouquine.business.interfaces.IClientBusiness;
import be.jebouquine.entities.Client;
import be.jebouquine.modelview.SessionAccount;

public class FOAccountAction implements SessionAware {

	private Map<String, Object> session;
	private static final String SA_KEY = "sessionAccount";
	private Client client;
	private IClientBusiness clientBusiness;
	private String checkPassword;

	public String loadAccount() {
		try {
			SessionAccount sa = (SessionAccount) session.get(SA_KEY);
			client = clientBusiness.findByID(sa.getId());
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String editAccount() {
		try {

			if (!client.getPassword().equals(checkPassword))
				return "error";

			SessionAccount sa = (SessionAccount) session.get(SA_KEY);
			client.setId(sa.getId());
			boolean modif = clientBusiness.modify(client);
			if (!modif) {
				return "error";
			}
			sa.setName(client.getFirstName() + " " + client.getLastName());
			return "success";
		} catch (Exception e) {
			return "error";
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// ---------------------------
	// -----GETTERS - SETTERS-----
	// ---------------------------

	public final Map<String, Object> getSession() {
		return session;
	}

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
