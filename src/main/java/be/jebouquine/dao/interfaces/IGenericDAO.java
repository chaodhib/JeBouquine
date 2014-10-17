package be.jebouquine.dao.interfaces;

public interface IGenericDAO<T> {

	public abstract void add(T object) throws Exception;

	public abstract void remove(T object);

	public abstract void modify(T object) throws Exception;
	
	
 
}