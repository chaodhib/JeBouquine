package be.jebouquine.business.singletons;

import org.springframework.transaction.annotation.Transactional;

import be.jebouquine.dao.interfaces.IGlobalParamDAO;
import be.jebouquine.entities.GlobalParam;

@Transactional(readOnly = false)
public class OrderBusinessSingleton {
	public static IGlobalParamDAO globalParamDAO;
	
	public static final String PARAM_TAUX_TVA = "TAUX_TVA";
	public static final String PARAM_INCREMENT_COMMANDE = "INCREMENT_COMMANDE";
	
	private static OrderBusinessSingleton instance;
	
	private OrderBusinessSingleton(){
		;
	}
	
	public static OrderBusinessSingleton getInstance(){ //TODO : gerer le risque de probleme en multithreading
		if(instance==null){
			instance=new OrderBusinessSingleton();
		}
		
		return instance;
	}
	
	public Integer getNextOrderNumber(){
		GlobalParam param= globalParamDAO.findByName(PARAM_INCREMENT_COMMANDE);
		Integer orderNumber;
		if(param==null){
			param=new GlobalParam();
			param.setName(PARAM_INCREMENT_COMMANDE);
			param.setValue("2");
			orderNumber=1;
			try {
				globalParamDAO.add(param);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else{
			orderNumber=Integer.parseInt(param.getValue());
			Integer nextOrderNumber=orderNumber+1;
			param.setValue(nextOrderNumber.toString());
			try {
				globalParamDAO.modify(param);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return orderNumber;
	}

	public static IGlobalParamDAO getGlobalParamDAO() {
		return globalParamDAO;
	}

	public static void setGlobalParamDAO(IGlobalParamDAO globalParamDAO) {
		OrderBusinessSingleton.globalParamDAO = globalParamDAO;
	}
}
