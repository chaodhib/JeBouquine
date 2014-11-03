package be.jebouquine.business.singletons;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import be.jebouquine.dao.interfaces.IGlobalParamDAO;
import be.jebouquine.entities.GlobalParam;

//@Transactional(readOnly = false)
public class OrderBusinessSingleton {
	private final TransactionTemplate transactionTemplate;
	public IGlobalParamDAO globalParamDAO;
	
	public static final String PARAM_TAUX_TVA = "taux_tva";
	public static final String PARAM_INCREMENT_COMMANDE = "increment_commande";
	
	private static OrderBusinessSingleton instance;
	
	
	private OrderBusinessSingleton(PlatformTransactionManager transactionManager){
		Assert.notNull(transactionManager, "The 'transactionManager' argument must not be null.");
		this.transactionTemplate=new TransactionTemplate(transactionManager);
		
		// transaction settings
		this.transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
	}
	
	public static OrderBusinessSingleton getInstance(PlatformTransactionManager transactionManager){ 
		//TODO : gerer le risque de probleme en multithreading si cette methode est appellé deux fois au meme moment
		if(instance==null){
			instance=new OrderBusinessSingleton(transactionManager);
		}
		
		return instance;
	}
	
	// Refactor de la methode en gerant la transaction de maniere programmatique car conflit quand on veut utiliser
	// L'AOP Transactional avec un singleton sans interface
	public Integer getNextOrderNumber() throws Exception{
		return transactionTemplate.execute(new TransactionCallback<Integer>() {

			@Override
			public Integer doInTransaction(TransactionStatus status) {
				try {
					GlobalParam param = globalParamDAO.findByName(PARAM_INCREMENT_COMMANDE);
					Integer orderNumber;
					
					if(param==null){
						orderNumber=1;
						param=new GlobalParam();
						param.setName(PARAM_INCREMENT_COMMANDE);
						param.setValue("2");
						globalParamDAO.add(param);
					} else{
						orderNumber=Integer.parseInt(param.getValue());
						Integer nextOrderNumber=orderNumber+1;
						param.setValue(nextOrderNumber.toString());
						globalParamDAO.modify(param);
					}
					
					return orderNumber;
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
				}
				return null;
			}});
	}
	
//	public Integer getNextOrderNumber() throws Exception{
//	GlobalParam param;
//	try {
//		param = globalParamDAO.findByName(PARAM_INCREMENT_COMMANDE);
//	} catch (Exception e1) {
//		throw new Exception(e1);
//	}
//	Integer orderNumber;
//	if(param==null){
//		param=new GlobalParam();
//		param.setName(PARAM_INCREMENT_COMMANDE);
//		param.setValue("2");
//		orderNumber=1;
//		try {
//			globalParamDAO.add(param);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	} else{
//		orderNumber=Integer.parseInt(param.getValue());
//		Integer nextOrderNumber=orderNumber+1;
//		param.setValue(nextOrderNumber.toString());
//		try {
//			globalParamDAO.modify(param);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	return orderNumber;
//}

	public IGlobalParamDAO getGlobalParamDAO() {
		return globalParamDAO;
	}

	public void setGlobalParamDAO(IGlobalParamDAO globalParamDAO) {
		this.globalParamDAO = globalParamDAO;
	}

}
