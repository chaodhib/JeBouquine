package be.jebouquine.controlers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import be.jebouquine.business.interfaces.IClientBusiness;
import be.jebouquine.entities.Client;
import be.jebouquine.exceptions.JeBouquineLoginException;
import be.jebouquine.modelview.SessionAccount;

public class FOLoginAction implements SessionAware {
	private static final String SA_KEY = "sessionAccount";
	private Map<String, Object> session;
	private Client client;
	private IClientBusiness clientBusiness;
	private String checkPassword;
	private boolean errorLogin;

	public String register() {
		boolean success;
		try {
			success = clientBusiness.add(client);
			if (!client.getPassword().equals(checkPassword)) {
				return "error";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
		if (success)
			return "success";
		else {
			return "error";
		}
	}

	private String login, password;

	public String login() {
		try {
			SessionAccount sa = clientBusiness.login(login, password);
			if (sa != null) {
				session.put(SA_KEY, sa);
				return "success";
			} else
				return "error";
		} catch (JeBouquineLoginException jble) {
			setErrorLogin(true);
			return "loginFailure";
		} catch (Exception e) {
			return "error";
		}
	}

	public String logout() {
		SessionAccount sa = (SessionAccount) session.remove(SA_KEY);
		if (sa != null)
			return "success";
		else
			return "error";

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public boolean isErrorLogin() {
		return errorLogin;
	}

	public void setErrorLogin(boolean errorLogin) {
		this.errorLogin = errorLogin;
	}

}
