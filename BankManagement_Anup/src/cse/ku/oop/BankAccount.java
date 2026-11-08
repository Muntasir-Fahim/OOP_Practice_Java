package cse.ku.oop;

public class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private String operation; // Latest Name of the transaction operation
    private double changeAmount; // Latest Changed amount
    public BankAccount(String number, String holdername, double balance){
      this.accountNumber = number;
      this.holderName = holdername;
      this.balance = balance;
    }
    public void deposit(double amount){
        this.balance += amount;
        this.changeAmount = amount;
        this.operation = "Deposited";
    }

    public void withdraw(double amount){

        this.balance -= amount;
        this.changeAmount = amount;
        this.operation = "Withdrawn";
    }
   public String getAccountNumber(){
        return this.accountNumber;
   }
    public double getBalance()
    {
        return balance;
    }

    public void statement(){
        System.out.println("Current balance: "+ this.balance+ " "+ this.operation+":"+this.changeAmount);
        //System.out.println("hello");
    }

    public String toString(){
       return "Account number:"+ this.accountNumber+ ", Holder name: "+ this.holderName+ ", Balance: "+ this.balance;
    }



}
