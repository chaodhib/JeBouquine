package be.jebouquine.controlers;

import java.util.List;

import be.jebouquine.business.interfaces.IBookBusiness;
import be.jebouquine.entities.Book;

public class FOFrontPageAction {

	private List<Book> bestSales;
	private List<Book> novelties;
	private IBookBusiness bookBusiness;

	public List<Book> getBestSales() {
		return bestSales;
	}

	public void setBestSales(List<Book> bestSales) {
		this.bestSales = bestSales;
	}

	public List<Book> getNovelties() {
		return novelties;
	}

	public void setNovelties(List<Book> novelties) {
		this.novelties = novelties;
	}
	
	public IBookBusiness getBookBusiness() {
		return bookBusiness;
	}

	public void setBookBusiness(IBookBusiness bookBusiness) {
		this.bookBusiness = bookBusiness;
	}

	public String frontPageDisplay(){
		bestSales = bookBusiness.bestSales();
		novelties = bookBusiness.novelties();
		return "success";
	}
	
	
}
