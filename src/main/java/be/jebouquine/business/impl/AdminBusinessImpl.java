package be.jebouquine.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.business.interfaces.IAdminBusiness;
import be.jebouquine.dao.interfaces.IAdminDAO;
import be.jebouquine.entities.Admin;

@Transactional(readOnly = false)
public class AdminBusinessImpl implements IAdminBusiness {

	private IAdminDAO client;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String adress;
	private String email;
	private String login;
	private String password;

	public IAdminDAO getClient() {
		return client;
	}

	public void setClient(IAdminDAO client) {
		this.client = client;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public boolean add(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Admin admin, String name, String firstname,
			String login, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Admin> findByCriteria(String name, String firstname,
			String login, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
