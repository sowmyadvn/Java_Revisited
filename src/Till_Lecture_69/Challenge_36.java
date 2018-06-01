public class Challenge_36 {

    public static void main(String[] args) {

        BankAccount bankAcc1 = new BankAccount();
        bankAcc1.setAccountNo(12345);
        bankAcc1.setBalance(200000);
        bankAcc1.setAccHolder("Sowmya Teja");
        bankAcc1.setEmail("sowtej@gmail.com");
        bankAcc1.setPhone(987654321);

        bankAcc1.deposit(-200);
        bankAcc1.withdraw(202000);
        bankAcc1.deposit(10000);
        bankAcc1.withdraw(200);

        BankAccount bankAcc2 = new BankAccount();//89101,"Teja",500000, "tej@gmail.com",123443565);
    }
}
