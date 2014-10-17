package be.jebouquine.dao.interfaces;

import be.jebouquine.entities.GlobalParam;

public interface IGlobalParamDAO extends IGenericDAO<GlobalParam> {

	public abstract GlobalParam findByName(String name);

	public abstract void save(GlobalParam globparam) throws Exception;

}