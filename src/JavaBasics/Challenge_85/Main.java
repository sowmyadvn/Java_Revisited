import java.util.Scanner;
public class Main {
	private static Scanner scanner = new Scanner(System.in);
	public static MobilePhone mobilePhone = new MobilePhone(" 330 440 5506");
	
	public static void main(String[] args) {
		boolean quit = false;
		startPhone();
		printActions();
		while (!quit) {
			System.out.println("Action? (5 for list)");
			int action = scanner.nextInt();
			scanner.nextLine();
			switch(action) {
				case 0:
					mobilePhone.printContacts();
					break;
				case 1:
					addContact();
					break;
				case 2:
					updateContact();
					break;
				case 3:
					removeContact();
					break;
				case 4:
					searchContact();
					break;
				case 5: 
					printActions();
					break;
				case 6:
					quit = true;
					System.out.println("Shutting down");
					break;
			}

		}
	}

	public static void startPhone() {
		System.out.println("Starting the phone...");
	}

	public static void printActions() {
		System.out.println(" 0 - View contacts \n1 - Add contact \n2 - Update contact \n3 - Remove contact \n4 - Search contact \n 5 - print Actions \n 6 - Shut Down");
	}

	public static void addContact() {
		System.out.println("Enter new contact name");
		String name = scanner.nextLine();
		System.out.println("Enter phone number"); 
		String phoneNumber = scanner.nextLine();
		Contact contact = Contact.storeContact(name,phoneNumber);

		if(mobilePhone.addNewContact(contact))
			System.out.println("Contact added");
		else
			System.out.println("Contact already exists");
	}

	public static void updateContact() {
		System.out.println("Enter contact name");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.findContact(name);
		if( existingContact == null)
			return;
		System.out.println("Enter new contact name");
		String newName = scanner.nextLine();
		System.out.println("Enter new contact Number");
		String phone = scanner.nextLine();

		Contact newContactNum = new Contact(newName,phone);
		if(mobilePhone.modifyContact(existingContact,newContactNum))
			System.out.println("Updated");
		else
			System.out.println("Couldnt be updated as doesnt exist");
	}

	public static void removeContact() {
		System.out.println("Remove which contact?");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.findContact(name);
		if( existingContact == null)
			return;
		if(mobilePhone.removeContact(existingContact))
			System.out.println("Removed contact successfully");
		else
			System.out.println("Couldnt remove contact");

	}

	public static void searchContact() {
		System.out.println("Contact name for search?");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.findContact(name);
		if( existingContact == null) {
			System.out.println("Contact not found");
			return;
		}

		System.out.println("Name:" + existingContact.getName() +" => Phone Number:" + existingContact.getPhone());
	}


}