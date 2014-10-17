package be.jebouquine.business.interfaces;

import be.jebouquine.modelview.Cart;

public interface ICartBusiness {
	
	public Cart getNewCart();
	
	public void addBookIntoCart(Cart cart, Integer bookId, Integer desiredQtt) throws Exception;
	
	public void removeCartLine(Cart cart, Integer bookId) throws Exception;

	public void modiftQuantity(Cart cart, Integer bookId, Integer desiredQtt) throws Exception;
}
