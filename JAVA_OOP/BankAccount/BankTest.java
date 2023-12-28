public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount(20.0, 50.0);
        BankAccount account2 = new BankAccount(60.0, 100.0);
        BankAccount account3 = new BankAccount(85.0, 75.0);

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        account1.checkingDeposit(12);
        System.out.println("The total balance of account1 is: $" + account1.getBalance());
        System.out.println("The total money is: $" + BankAccount.getTotalMoney());

        account2.savingsDeposit(34);
        System.out.println("The total balance of account2 is: $" + account2.getBalance());
        System.out.println("The total money is: $" + BankAccount.getTotalMoney());

        account3.checkingDeposit(10);
        System.out.println("The total balance of account3 is: $" + account3.getBalance());
        System.out.println("The total money is: $" + BankAccount.getTotalMoney());

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        account1.checkingWithdraw(20);
        System.out.println("The total balance of account1 is: $" + account1.getBalance());
        System.out.println("The total money is: $" + BankAccount.getTotalMoney());

        account2.savingsWithdraw(15);
        System.out.println("The total balance of account2 is: $" + account2.getBalance());
        System.out.println("The total money is: $" + BankAccount.getTotalMoney());

        account3.checkingWithdraw(27);
        System.out.println("The total balance of account3 is: $" + account3.getBalance());
        System.out.println("The total money is: $" + BankAccount.getTotalMoney());

        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println("The number of accounts is: " + BankAccount.getAccounts());
        System.out.println("The total money of all accounts is: $" + BankAccount.getTotalMoney());

        //Account Number For Each Account
        System.out.println("The account number of account1 : " + account1.getAccountNumber());
        System.out.println("The account number of account2 : " + account2.getAccountNumber());
        System.out.println("The account number of account3 : " + account3.getAccountNumber());
    }
}

