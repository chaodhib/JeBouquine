package be.jebouquine.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class Comment {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="CONTENT", columnDefinition="TEXT")
	private String content;

	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Book book;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Client getClient() {
		return client;
	}

	public Book getBook() {
		return book;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
