package be.jebouquine.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class OrderLine {
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;

	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="PRICE")
	private Double price;
	
	@ManyToOne
	private Book book;

	public final Integer getId() {
		return id;
	}

	public final Integer getQuantity() {
		return quantity;
	}

	public final Double getPrice() {
		return price;
	}

	public final Book getBook() {
		return book;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public final void setPrice(Double price) {
		this.price = price;
	}

	public final void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	
	
}
