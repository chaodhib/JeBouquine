package be.jebouquine.modelview;

public class SessionAccount {
	/**
	 * the name to display in the "Hello M. XXXX" of HeaderBand.jsp 
	 */
	
	private String name; // 
	/**
	 * ID of the client or the admin account
	 */
	private Integer id; // 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
