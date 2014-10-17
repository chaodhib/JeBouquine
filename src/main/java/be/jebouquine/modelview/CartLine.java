package be.jebouquine.modelview;

public class CartLine {
	private Integer bookId;
	private String bookTitle;
	private Double subTotalPrice;
	private Integer quantity;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Double getSubTotalPrice() {
		return subTotalPrice;
	}
	public void setSubTotalPrice(Double subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}

	
	
}
