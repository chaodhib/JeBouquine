package be.jebouquine.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;

	@OneToMany(cascade=CascadeType.ALL)
	private List<OrderLine> orderLines;
	
	@ManyToOne
	private Client client;
	
	@Column(name="ADDRESS")
	private String address;

	@ManyToOne
	private OrderState orderState;
	
	private Calendar date;
	
	private String orderRef;
	
	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderlines) {
		this.orderLines = orderlines;
	}


	public final Client getClient() {
		return client;
	}

	public final OrderState getOrderState() {
		return orderState;
	}


	public final void setClient(Client client) {
		this.client = client;
	}


	public final void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((orderLines == null) ? 0 : orderLines.hashCode());
		result = prime * result
				+ ((orderState == null) ? 0 : orderState.hashCode());
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
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderLines == null) {
			if (other.orderLines != null)
				return false;
		} else if (!orderLines.equals(other.orderLines))
			return false;
		if (orderState == null) {
			if (other.orderState != null)
				return false;
		} else if (!orderState.equals(other.orderState))
			return false;
		return true;
	}


	public String getOrderRef() {
		return orderRef;
	}


	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}
	
	
	
	
}
