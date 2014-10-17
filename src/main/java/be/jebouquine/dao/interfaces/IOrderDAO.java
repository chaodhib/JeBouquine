package be.jebouquine.dao.interfaces;

import be.jebouquine.entities.Order;

public interface IOrderDAO extends IGenericDAO<Order> {
	
	/*
	 *Tous les champs de l'objet Order doivent être préalablement rempli avant de le passer  
	 * à cette méthode. Dans le cas contraire, elle retourne une exception.
	 */
	@Override
	public void add(Order object) throws Exception;
	
	public Order findByID(Integer id);
	/*
	 * remove & modify herités de IGenericDAO
	 * 
	 * 
	findAll(); //Pas pour le moment
	
	findByCriteria(); //Pas pour le moment
	
	*/
	
}
