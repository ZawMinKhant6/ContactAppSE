package modal;

public class Contact {
	
	
	private String name;
	private String phoneNumber;
	private String secNumber;
	private Long id;
	
	public Contact() {
		
	}
	
	

	public Contact(String name, String phoneNumber, String secNumber, Long id) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.secNumber = secNumber;
		this.id = id;
	}



	public Contact(String name, String phoneNumber, String secNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.secNumber = secNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSecNumber() {
		return secNumber;
	}

	public void setSecNumber(String secNumber) {
		this.secNumber = secNumber;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", secNumber=" + secNumber + "]";
	}
	
}
