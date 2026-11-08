package cse.ku.oop;

import java.util.*;

public class Transaction {
    private int TransactionId;
    private String type;
    private double amount;
    private String accountnumber;

    public Transaction(String accountnumber, String type,double amount){
        Random rand = new Random();
        this.accountnumber = accountnumber;
        this.type = type;
        this.amount = amount;
        TransactionId = rand.nextInt(10000,99999);

    }


    public String getTransactionDetails(){
        return "Transaction ID: " + this.TransactionId + '\n' + "Account Number: " + this.accountnumber + '\n' + "Type: " + this.type + "\nAmount:" + this.amount;
    }
    public String getAccountNumber()
    {
        return this.accountnumber;
    }

}
