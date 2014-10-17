package be.jebouquine.business.interfaces;

import java.util.List;

import be.jebouquine.entities.Admin;

public interface IAdminBusiness {
	public boolean add(Admin admin);
	public boolean remove(Admin admin);
	public List<Admin> findByCriteria(String name, String firstname, String login, String email);
	public boolean modify(Admin admin, String name, String firstname, String login, String email);
}
