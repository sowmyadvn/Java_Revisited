public class BankAccount {

    private long accountNo;
    private String accHolder;
    private double balance;
    private String email;
    private long phone;

    public BankAccount()
    {
        this(12345,"Hi",200,"tj@yahoo.com",3456789);
        System.out.println("Empty constructor called");
    }

    public BankAccount(long accountNo, String accHolder, double balance, String email, long phone) {
        this.balance = balance;
        this.phone = phone;
        this.accHolder = accHolder;
        this.accountNo = accountNo;
        this.email = email;
        System.out.println("Another constructor with parameters called");
    }
    public long getAccountNo() {
        return this.accountNo;
    }

    public String getAccHolder() {
        return this.accHolder;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getEmail() {
        return this.email;
    }

    public long getPhone() {
        return this.phone;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(this.getBalance()+amount);
            System.out.println("New balance after deposit is:"+ this.getBalance()+" dollars");
        }
        else {
            System.out.println("Enter valid amount to deposit");
        }
    }

    public void withdraw(double amount) {
        double bal = this.getBalance();
        if (bal-amount > 0 ) {
            bal -= amount;
            setBalance(bal);
            System.out.println("Amount after withdrawal:"+ bal+" dollars");
        }
        else {
            System.out.println("Not enough funds to withdraw. You only have:"+bal+" dollars");
        }
    }

 }
