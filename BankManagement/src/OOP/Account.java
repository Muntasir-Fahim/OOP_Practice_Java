package OOP;

import java.util.Random;

public class Account {
    private String accountnumber;
    private String userName;
    private String accounttype;
    private double balance;

    //private Transaction tran;

    public Account(String accountnumber, String userName, String accounttype, double balance){
        this.accountnumber = accountnumber;
        this.userName = userName;
        this.accounttype = accounttype;
        this.balance = balance;
    }


    Random random = new Random();

    public void setNumber(String number)
    {
        this.accountnumber = number;
    }

    public String getNumber(){
        return this.accountnumber;
    }

    public void setUserName(String name){
        this.userName = name;
    }
    public String getUserName(){
        return this.userName;
    }

    public void setType(String type){
        this.accounttype = type;
    }

    public  String getType(){
        return this.accounttype;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        this.balance = this.balance + amount;

        Transaction tran = new Transaction("00"+accountnumber,"Today","Deposit",amount,balance,accountnumber);

//        tran.setId("00"+accountnumber);
//        tran.setType("Deposit",amount);
//        tran.setAccountnumber(accountnumber);
//        tran.setAmount(balance);
//        tran.setdate("Today");
        System.out.println(tran.getTransactionDetails());
    }

    public boolean withdraw(double amount){
        if(this.balance>=amount) {
            this.balance = this.balance - amount;

            Transaction tran = new Transaction("00"+accountnumber,"Today","Withdraw",amount,balance,accountnumber);

//            tran.setId();
//            tran.setType();
//            tran.setAccountnumber(accountnumber);
//            tran.setAmount(balance);
//            tran.setdate();
            System.out.println(tran.getTransactionDetails());

            return true;
        }
        else return false;

    }

    public String getAccountDetails(){

        return "Account number: "+ this.accountnumber + " Name: " + this.userName + "Type: " + this.accounttype + " Balance: "+ this.balance;
    }
}