public class Branch {

	// You job is to create a simple banking application.
        // There should be a Bank class
        // It should have an arraylist of Branches
        // Each Branch should have an arraylist of Customers
        // The Customer class should have an arraylist of Doubles (transactions)
        // Customer:
        // Name, and the ArrayList of doubles.
        // Branch:
        // Need to be able to add a new customer and initial transaction amount.
        // Also needs to add additional transactions for that customer/branch
        // Bank:
        // Add a new branch
        // Add a customer to that branch with initial transaction
        // Add a transaction for an existing customer for that branch
        // Show a list of customers for a particular branch and optionally a list
        // of their transactions
        // Demonstration autoboxing and unboxing in your code
        // Hint: Transactions
        // Add data validation.
        // e.g. check if exists, or does not exist, etc.
        // Think about where you are adding the code to perform certain actions
	private String branchName;
	private ArrayList<Customer> customers;
	private Scanner scanner;

	private Branch(String branchName) {
		this.branchName = branchName;
		this.customers = new ArrayList<Customer>();
		scanner = new Scanner(System.in);
	}

	private Branch(String branchName, Customer customer) {
		this.branchName = branchName;
		this.customers = new ArrayList<Customer>();
		this.customers.add(customer);
		scanner = new Scanner(System.in);
	}

	public String getBranch() {
		return this.branchName();
	}

	public ArrayList<Customer> getCustomerDetails()  {
		return this.customers;
	}

	public static Branch createBranch(String branchName, String name, double initialDeposit ) {
		Customer customer = new Customer(name,initialDeposit);
		return new Branch(branchName,customer);
	} 

	public static Branch createBranch(String branchName) {
		return new Branch(branchName);
	}

	public static void main(String[] args) {
		bool quit = false;
		while (!quit) {
			System.out.println("Enter actions: ");
			printActions();
			int action = scanner.nextInt();
			switch(action) {
				case 1: 
					addNewCustomer();
					break;
				case 2:
					addTransaction();
					break;
				case 3:
					printCustomers();
					break;
				case 4:
					searchCustomer();
					break;
				case 5:
					quit = true;
					break;
			}
		}
	}

	public static void addNewCustomer() {
		System.out.println("Enter new customer name");
		String customerName = scanner.nextLine();
		System.out.println("Enter initial transaction");
		double initialDeposit = scanner.nextDouble();
		if(!searchCustomer(customerName)) {
			Customer customer = Customer.addnewCustomer(customerName, initialDeposit);
			if(customer == null)
				return;
			else {
				customers.add(customer);
				System.out.println("New customer added to branch");
			}
		}
		else
			System.out.println("Error adding customer. Customer with the name"+ customerName +" already exists.");
	}

	public static void searchCustomer() {
		System.out.println("Enter customer name to get transactions:");
		String customerName = scanner.nextLine();
		if(searchCustomer(customerName) >= 0)
			System.out.println("Found customer transactions");
		else
			System.out.println("No such customer found");
	}

	public static int searchCustomer(String customerName) {
		for(int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getCustomerName() == customerName) 
				return i;
		}
		return -1;
	}

	public static void printCustomers() {
		for (int i = 0; i < customers.size(); i++) {
			System.out.println(customers.get(i).getCustomerName()+" => ");
			ArrayList<Double> transactions = customers.get(i).getTransactions();
			for(int i = 0; i < transactions.size(); i++) {
				System.out.print(transactions.get(i).doubleValue()+" ");
			}
		}
	}

	public void printActions() {
		System.out.println("1 - Add new customer\n" +
						   "2 - Add transaction to an existing customer account \n "+
						   "3 - Search for a customer"\n +
						   "4 - Print customer information "+
						   "5 - Exit");
	}



}