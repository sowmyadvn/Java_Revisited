public class Customer {
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
	private String customerName;
	private ArrayList<Double> transactions;

	public Customer(String customerName) {
		this.customerName = customerName;
		this.transactions = new ArrayList<Double>();
	}

	public Customer(String customerName, double initialDeposit) {
		this.customerName = customerName;
		this.transactions = new ArrayList<Double>();
		this.transactions.add(Double.valueOf(initialDeposit));
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public ArrayList<Double> getTransactions(String customerName) {
		
		return this.transactions;
	}

	public ArrayList<Double> getTransactions() {
		return this.transactions;
	}

	public static Customer addnewCustomer(String name, double initialDeposit) {
		return new Customer(name,initialDeposit);
	}

	public static boolean addNewTransaction(double deposit) {
		if(deposit > 0) {
			this.transactions.add(Double.valueOf(deposit));
			return true;
		}
		else
			return false;


	}

}