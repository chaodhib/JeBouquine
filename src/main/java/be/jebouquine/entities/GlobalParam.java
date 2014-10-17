package be.jebouquine.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="GLOBAL_PARAM")
public class GlobalParam {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name="NAME", unique = true)
	private String name;

	@Column(name="VALUE")
	private String value;

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
