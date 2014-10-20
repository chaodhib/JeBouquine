package be.jebouquine.controlers;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import be.jebouquine.business.interfaces.ICartBusiness;
import be.jebouquine.modelview.Cart;
import be.jebouquine.modelview.CartLine;

public class FOCartAction  implements SessionAware{
	private static final String CART_KEY="cart";
	private ICartBusiness cartBusiness;
	private Map<String,Object> session;

	private Integer bookId;
	private Cart cart;
	
	// METHOD ACTION 1
	private Integer desiredQtt;

	
	public String addBookIntoCart (){
		initiaseCart();
		
		try {
			cartBusiness.addBookIntoCart(cart, bookId, desiredQtt);
			return "success";
		} catch (Exception e) {
			e.printStackTrace(); //TODO: correct exception handling
			return "error";
		}
	}
	
	// METHOD ACTION 2
	public String loadCart(){
		initiaseCart();
		
		return "success";
	}
	
	// METHOD ACTION 3
	
	public String deleteCartLine(){
		initiaseCart();
		
		try {
			cartBusiness.removeCartLine(cart, bookId);
			return "success";
		} catch (Exception e) {
			e.printStackTrace(); // Gestion des exceptions
			return "error";
		}
	}
	
	// METHOD ACTION 4
	
	private Map<String, String[]> modifMap=new HashMap<String, String[]>(); // INPUT
	
	private CartLine cartLine;
	
	public String modifyQuantity(){
		initiaseCart();
		
		String[] modif= modifMap.keySet().toArray(new String[0]);
		Integer bookId, desiredQtt;
		for (String s : modif){
			try {
				bookId=Integer.parseInt(s);
				desiredQtt=Integer.parseInt(((String[]) modifMap.get(s))[0]);
				cartBusiness.modiftQuantity(cart, bookId, desiredQtt);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return "error";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		return "success";
	}
	
	private void initiaseCart(){
		cart=(Cart) session.get(CART_KEY);
		if(cart==null){
			cart=cartBusiness.getNewCart();
			session.put(CART_KEY, cart);
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Integer getDesiredQtt() {
		return desiredQtt;
	}

	public void setDesiredQtt(Integer desiredQtt) {
		this.desiredQtt = desiredQtt;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public ICartBusiness getCartBusiness() {
		return cartBusiness;
	}


	public void setCartBusiness(ICartBusiness cartBusiness) {
		this.cartBusiness = cartBusiness;
	}

	public CartLine getCartLine() {
		return cartLine;
	}

	public void setCartLine(CartLine cartLine) {
		this.cartLine = cartLine;
	}

	public Map<String, String[]> getModifMap() {
		return modifMap;
	}

	public void setModifMap(Map<String, String[]> modifMap) {
		this.modifMap = modifMap;
	}
	
	
}
