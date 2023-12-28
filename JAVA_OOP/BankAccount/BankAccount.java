import java.util.Random;
public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    //Add the following class attribute: account number.
    private String accountNumber = "";

    private static int accounts = 0;
    private static double totalMoney = 0; // refers to the sum of all bank account checking and savings balances

    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accounts++;
        totalMoney += (checkingBalance + savingsBalance);
        this.accountNumber = getRandomAccountNumber();
    }

    // GETTERS
    // for checking, savings, accounts, and totalMoney
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public static int getAccounts(){
        return accounts;
    }

    public static double getTotalMoney(){
        return totalMoney;
    }
    
    public String getAccountNumber(){
        return this.accountNumber;
    }

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void checkingDeposit(double money){
        this.checkingBalance += money;
        totalMoney += money;
    }

     public void savingsDeposit(double money){
        this.savingsBalance += money;
        totalMoney += money;
    }
    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
     // - all deposits and withdrawals should affect totalMoney
    public void checkingWithdraw(double money){
        if(this.checkingBalance > money){
            this.checkingBalance -= money;
            totalMoney -= money;
        }
        else {
            System.out.println("There is no enough money in checking account.");
        }
        
    }

    public void savingsWithdraw(double money){
        if(this.savingsBalance > money){
            this.savingsBalance -= money;
            totalMoney -= money;
        }
        else {
            System.out.println("There is no enough money in savings account.");
        }
        
    }
    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public double getBalance(){
        double totalBalance = this.checkingBalance + this.savingsBalance;
        return totalBalance;
    }

    //Create a private method that returns a random ten digit account number.
    private String getRandomAccountNumber(){
        String accountNumber = "";
        Random randMachine = new Random();
        int i=0;
        while (i < 10) {
            int randNumber = randMachine.nextInt(9);
            accountNumber += randNumber;
            i++;
        }
        return accountNumber;
    }
}
