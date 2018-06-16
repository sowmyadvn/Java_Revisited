public class Contact {
	private String name;
	private String phoneNumber;

	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Contact() {
		this.name = "";
	}

	public String getPhoneNumber(String name) {
		if(name == this.name)
			return this.phoneNumber;
		else
			return null;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phoneNumber;
	}

	public static Contact storeContact(String name, String phoneNumber) {
		return new Contact(name,phoneNumber);
	}

}