package be.jebouquine.modelview;

import java.util.List;

public class Cart {
	private List<CartLine> lines;
	private Integer nberLines;
	private Double totalPrice;
	
	public List<CartLine> getLines() {
		return lines;
	}

	public void setLines(List<CartLine> lines) {
		this.lines = lines;
	}

	public Integer getNberLines() {
		return nberLines;
	}

	public void setNberLines(Integer nberLines) {
		this.nberLines = nberLines;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
