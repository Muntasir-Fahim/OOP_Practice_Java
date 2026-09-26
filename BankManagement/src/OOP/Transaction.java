package OOP;

import javax.swing.*;

public class Transaction {
    private String TransactionId;
    private String date;
    private String type;
    private double changeAmount;
    private double amount;
    private String accountnumber;

    public Transaction(String id, String date, String type,double changeAmount, double amount, String accountnumber){
        this.TransactionId = id;
        this.date = date;
        this.type = type;
        this.changeAmount = changeAmount;
        this.amount = amount;
        this.accountnumber = accountnumber;

    }

    public void setId(String number)
    {
        this.TransactionId = number;
    }

    public String getId(){
        return this.TransactionId;
    }

    public void setdate(String number)
    {
        this.date = number;
    }

    public String getdate(){
        return this.date;
    }

    public void setType(String value, double amount)
    {
        this.type = value;
        this.changeAmount = amount;
    }

//    public String getType(){
//        return this.type;
//
//
//    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }
    public double getAmount()
    {
        return this.amount;
    }

    public void setAccountnumber(String number)
    {
        this.accountnumber = number;
    }
    public String getAccountnumber()
    {
        return this.accountnumber;
    }

    public String getTransactionDetails(){
        return "Transaction ID "+ this.TransactionId + " | Date: " + this.date + " | " + this.type + " Amount: " + this.changeAmount + " | Total Amount: "+ this.amount + " | Account Number: "+ this.accountnumber;
    }

}
