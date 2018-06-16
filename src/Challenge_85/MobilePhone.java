import java.util.ArrayList;
	    // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.
public class MobilePhone {
	private ArrayList<Contact> contactList;
	private String myNumber;

	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.contactList = new ArrayList<Contact>();

	}

	public boolean addNewContact(Contact contact) {
		if (searchContact(contact.getName()) >= 0) {
			System.out.println("Contact already exists");
			return false;
		}
		else {
			this.contactList.add(contact);
			return true;
		}

	}

	public boolean modifyContact(Contact oldContact, Contact newContact) {
		int position = searchContact(oldContact);
		if( position < 0) {
			System.out.println("No matching contact found");
			return false;
		}
		this.contactList.set(position, newContact);
		System.out.println("Contact updated");
		return true;
	}

	public boolean removeContact(String name) {
		int position = searchContact(name);
		if(position < 0) {
			System.out.println("No matching contact found");
			return false;
		}
		this.contactList.remove(position);
		System.out.println("Matching contact removed");
		return true;
	}

	public boolean removeContact(Contact contact) {
		int position = searchContact(contact);
		if(position < 0) {
			System.out.println("No matching contact found");
			return false;
		}
		this.contactList.remove(position);
		System.out.println("Matching contact removed");
		return true;
	}

	private int searchContact(String name) {
		for(int i = 0; i < this.contactList.size(); i++) {
			Contact contact = this.contactList.get(i);
			if(contact.getName() == name)
				return i;
		}
		return -1;
	}

	private int searchContact(Contact contact) {
		return this.contactList.indexOf(contact);
	}

	public String findContact(Contact contact) {
		if(searchContact(contact) >= 0)
			return contact.getName();
		else
			return null;
	}

	public Contact findContact(String name) {
		int position = searchContact(name);
		if(position >= 0) {
			return this.contactList.get(position);
		}
		else
			return null;
	}
	public void printContacts() {
		for (int i = 0; i < this.contactList.size(); i++) {
			System.out.println("Name:"+this.contactList.get(i).getName() + " -> Phone Number:" + this.contactList.get(i).getPhone());
		}
	}
}