        
public class Bank {
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
        private static ArrayList<Branch> branches; 
        private Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
               
                boolean quit = false;
                while( !quit) {
                        printActions();
                        int action = scanner.nextLine();

                        switch(action) {
                                case 1:
                                        addBranch();
                                        break;
                                case 2:
                                        addBranchWithCustomer();
                                        break;
                                case 3:
                                        addCustomerToBranch();
                                        break;
                                case 4:
                                        addCustomerTransaction();
                                        break;
                                case 5:
                                        searchBranch();
                                        break;
                                case 6:
                                        quit = true;
                                        break;
                        }
                }
        }


        public static Branch addBranch() {
                System.out.println("Enter new branch name");
                String branchName = scanner.nextLine();
                if(!searchBranch(branchName)) {
                        Branch branch = createBranch(branchName);
                        branches.add(branch);
                        System.out.println("New branch created");
                        return branch;
                }
                else {
                        System.out.println("Branch already exists");
                        return null;
                }


        }

        public static void addBranchWithCustomer() {
                Branch branch = addBranch();
                branch.addNewCustomer();

        }

        public static void addCustomerToBranch() {
                System.out.println("Enter branch to which customer has to be added");
                String branchName = scanner.nextLine();
                int position = searchBranch(branchName);
                if( position >= 0) {
                       Branch branch = branches.get(position);
                       branch.addNewCustomer();
                }
                else {
                        System.out.println("No such branch exists");
                }
        }

        public static void addCustomerTransaction() {
                System.out.println("Enter branch to which customer has to be added");
                String branchName = scanner.nextLine();
                int position = searchBranch(branchName);
                if( position >= 0) {
                        Branch branch = branches.get(position);
                        System.out.println("Enter customer details");
                        String customerName = scanner.nextLine();
                        int customerPos = branch.searchCustomer(customerName);
                        if(customerPos >= 0) {
                                Customer customer = branch.get(customerPos);
                                System.out.println("Enter transaction amount");
                                double deposit = scanner.nextDouble();
                                customer.getTransactions(customer.getCustomerName()).add(Double.valueOf(deposit));
                        }
               }
        }
 
        public static int searchBranch(String branchName) {
                for(int i = 0; i < branches.size(); i++) {
                        if(branches.get(i).getBranch().equals(branchName))
                                return i;
                }
                return -1;
        }

        public void printActions() {
                System.out.println("1- Add Branch \n"+
                                   "2 - Add new branch with customer \n"+
                                   "3 - Add new customer to branch \n"+
                                   "4 - Add transaction to customer account \n"+
                                   "5 - search Branch\n"+
                                   "6 - Exit");
        }
}