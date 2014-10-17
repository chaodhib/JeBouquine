package be.jebouquine.business.impl;

import java.util.ArrayList;

import be.jebouquine.business.interfaces.IBookBusiness;
import be.jebouquine.business.interfaces.ICartBusiness;
import be.jebouquine.entities.Book;
import be.jebouquine.modelview.Cart;
import be.jebouquine.modelview.CartLine;

public class CartBusinessImpl implements ICartBusiness {
	
	private IBookBusiness bookBusiness;

	@Override
	public Cart getNewCart() {
		Cart cart=new Cart();
		cart.setLines(new ArrayList<CartLine>());
		cart.setNberLines(new Integer(0));
		cart.setTotalPrice(new Double(0.0));
		return cart;
	}

	/**
	 * Take into parameter a non-null reference to a cart 
	 * @throws Exception 
	 */
	@Override
	public void addBookIntoCart(Cart cart, Integer bookId, Integer desiredQtt) throws Exception {
		if(cart==null)
			throw new Exception("null reference to cart");
		else if(bookId==null)
			throw new Exception("null reference to bookId");
		else if(desiredQtt==null)
			throw new Exception("null reference to desiredQtt");
		
		CartLine currentLine=null;
		for(CartLine line : cart.getLines()){
			if(line.getBookId()==bookId){
				currentLine=line;
				break;
			}
		}
		
		Book book=bookBusiness.findByID(bookId);
		if(currentLine==null){ // cas standard : commander x exemplaires d'un livre non présent dans le panier
			currentLine=new CartLine();
			currentLine.setBookId(bookId);
			currentLine.setBookTitle(book.getTitle());
			currentLine.setSubTotalPrice(book.getPrice()*desiredQtt);
			currentLine.setQuantity(desiredQtt);
			cart.getLines().add(currentLine);
			cart.setNberLines(cart.getNberLines()+1);
			cart.setTotalPrice(cart.getTotalPrice()+currentLine.getSubTotalPrice());
		} else{ // cas alternatif : Rajouter y exemplaire d'un livre deja present dans le panier
			currentLine.setSubTotalPrice(currentLine.getSubTotalPrice()+book.getPrice()*desiredQtt);
			currentLine.setQuantity(currentLine.getQuantity()+desiredQtt);
		}
	}
	
	@Override
	public void removeCartLine(Cart cart, Integer bookId) throws Exception {
		if(cart==null)
			throw new Exception("null reference to cart");
		else if(bookId==null)
			throw new Exception("null reference to bookId");
		
		CartLine currentLine=null;
		for(CartLine line : cart.getLines()){
			if(line.getBookId()==bookId)
				currentLine=line;
		}
		
		if(currentLine!=null){
			cart.getLines().remove(currentLine);
			cart.setNberLines(cart.getNberLines()-1);
			if(cart.getNberLines()!=0)
				cart.setTotalPrice(cart.getTotalPrice()-currentLine.getSubTotalPrice());
			else
				cart.setTotalPrice(0.0);
			return;
		} else{
			throw new Exception("CartLine doesn't exist");
		}
	}
	
	@Override
	public void modiftQuantity(Cart cart, Integer bookId, Integer desiredQtt)
			throws Exception {
		if(cart==null)
			throw new Exception("null reference to cart");
		else if(bookId==null)
			throw new Exception("null reference to bookId");
		else if(desiredQtt==null || desiredQtt<0)
			throw new Exception("null reference to desiredQtt");
		
		if(desiredQtt==0){
			removeCartLine(cart, bookId);
			return;
		}
		
		CartLine currentLine=null;
		for(CartLine line : cart.getLines()){
			if(line.getBookId()==bookId){
				currentLine=line;
				break;
			}
		}
		
		Book book=bookBusiness.findByID(bookId);
		cart.setTotalPrice(cart.getTotalPrice()-currentLine.getSubTotalPrice());
		currentLine.setSubTotalPrice(book.getPrice()*desiredQtt);
		currentLine.setQuantity(desiredQtt);
		
		if(cart.getNberLines()!=0)
			cart.setTotalPrice(cart.getTotalPrice()+currentLine.getSubTotalPrice());
		else
			cart.setTotalPrice(0.0);
	}

	public IBookBusiness getBookBusiness() {
		return bookBusiness;
	}

	public void setBookBusiness(IBookBusiness bookBusiness) {
		this.bookBusiness = bookBusiness;
	}

}
