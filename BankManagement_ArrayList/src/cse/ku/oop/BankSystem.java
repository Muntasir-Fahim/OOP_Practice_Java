package cse.ku.oop;

import java.util.ArrayList;

public class BankSystem {
    private BankAccount account;
    //private Transaction transaction[];
    //private BankAccount accountholders[]; //Account array for storing the bank accounts

    private ArrayList<Transaction> transaction = new ArrayList<>();
    private ArrayList<BankAccount> accountholders = new ArrayList<>();

    //private int currentIndex=0; //Pointer of accounts
    //private int tranCount = 0;
    //private int delCount = 0;

    //public BankSystem(int numberOfAccounts)
    //{
    //    this.accountholders = new BankAccount[numberOfAccounts];
    //    this.transaction = new Transaction[100];
    //}

    public void addAccount(String number, String name, double initBalance){
        if(searchAccount(number) == null){
            BankAccount account = new BankAccount(number, name, initBalance);
    //        this.accountholders[currentIndex] = account; //Adding account object to array
    //        this.currentIndex++; //Increment the pointer
            accountholders.add(account);
        }
        else System.out.println("Already created");
    }

    public void addTransaction(String number,String type, double amount){
        Transaction tran = new Transaction(number,type,amount);
    //    this.transaction[tranCount] = tran;
    //    this.tranCount++;
        transaction.add(tran);
    }

    public BankAccount searchAccount(String number){
        for(BankAccount acc : accountholders){
            if(acc.getAccountNumber().equals(number)) {
                return acc; //If found return the account object
            }
        }
        return null; //If account not found
    }

    public int getNumberOfCustomers(){
        return accountholders.size();
    }

    public void createAccount(BankAccount account)
    {
        this.account = account;
        System.out.println("Created account");
    }


    public void performtransaction(String number,String type, double amount)
    {
        BankAccount acnt = searchAccount(number);
        if(acnt == null) {System.out.println("Account not found");return;}

        if(type.equals("withdraw") ) {
            acnt.withdraw(amount);
            addTransaction(number,"withdraw",amount);
        }

        else if (type.equals("deposit")){
            acnt.deposit(amount);
            addTransaction(number,"deposit",amount);
        }

    }

    //public void performDeposit(double amount){
    //    this.account.deposit(amount);
    //}
    //
    //public void performWithdraw(double amount){
    //        this.account.withdraw(amount);
    //}
    public void printStatement(String number)
    {
        boolean notFound = true;
        for(Transaction tran: transaction)
        {
            if(tran.getAccountNumber().equals(number))
            {
                System.out.println(tran.getTransactionDetails());
                notFound = false;
            }
        }

        if(notFound)
        {
            System.out.println("No transactions found for " + number);
        }

    }
    //public void printStatement(){
    //    this.account.statement();
    //}

    public void accountDetails(){
        System.out.println(this.account);
    }

    //public void deleteAccount(String accountNumber)
    //{
    //    for(int i = 0; i < currentIndex; i++){
    //        if(this.accountholders[i].getAccountNumber().equals(accountNumber))
    //        {
    //            this.accountholders[i] = null;
    //            System.out.println("Deleted " + accountNumber);
    //            for(int j = i; j < currentIndex-1; j++)
    //            {
    //                this.accountholders[j] = this.accountholders[j+1];
    //            }
    //            this.accountholders[currentIndex] = null;
    //            currentIndex--;
    //            this.delCount++;
    //            return;
    //        }
    //    }
    //
    //    System.out.println(accountNumber + " does not exist");
    //
    //}

    public void deleteAccount(String accountNumber){

        accountholders.remove(searchAccount(accountNumber));
        System.out.println("Account deleted");
    }

    public void listAccounts(){
        if(accountholders.isEmpty()){
            System.out.println("No accounts in the list");
            return;
        }
        System.out.println('\n' + "List of accounts: ");
        for(BankAccount acc: accountholders)
        {
            System.out.println(acc.toString());
        }
    }

}
