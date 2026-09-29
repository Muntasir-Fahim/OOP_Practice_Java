package OOP;

import java.util.*;

public class Account {
    private String accountnumber;
    private String userName;
    private String accounttype;
    private double balance;

    private ArrayList<Transaction> TranList = new ArrayList<>();

    private static ArrayList<Account> AccountList = new ArrayList<>();

    //private Transaction tran;

    public Account(String accountnumber, String userName, String accounttype, double balance){
        this.accountnumber = accountnumber;
        this.userName = userName;
        this.accounttype = accounttype;
        this.balance = balance;
        AccountList.add(this);
    }


    //Random random = new Random();

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

        TranList.add(tran);

        //System.out.println(tran.getTransactionDetails());
    }

    public boolean withdraw(double amount){
        if(this.balance>=amount) {
            this.balance = this.balance - amount;

            Transaction tran = new Transaction("00"+accountnumber,"Today","Withdraw",amount,balance,accountnumber);

            TranList.add(tran);
            //System.out.println(tran.getTransactionDetails());

            return true;
        }
        else return false;

    }

    public String getAccountDetails(){

        return "Account number: "+ this.accountnumber + " Name: " + this.userName + " Type: " + this.accounttype + " Balance: "+ this.balance;
    }

    public ArrayList<Transaction> getTranList(){
        return TranList;
    }
    public static ArrayList<Account> getAccountList(){
        return AccountList;
    }

    public static boolean removeAccount(String AccountNum){
        for(Account u: AccountList){
            if(u.getNumber().equals(AccountNum)){
                AccountList.remove(u);
                return true;
            }
        }
        return false;
    }

}