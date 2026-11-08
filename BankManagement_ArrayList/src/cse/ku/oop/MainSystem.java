package cse.ku.oop;

public class MainSystem {

    public static void main(String[] args){
        BankSystem banksys = new BankSystem(); //Maximum 10 accounts
        banksys.addAccount("00011", "Jhon", 100);
        banksys.addAccount("00022", "Bob", 250);
        System.out.println("Number of customers in the bank: "+ banksys.getNumberOfCustomers());
        BankAccount baccnt = banksys.searchAccount("00022");
//        if(baccnt==null){
//            System.out.println("Customer not found");
//        }
//        else{
//            System.out.println("Found the customer>>"+baccnt);
//        }

        BankAccount baccount1 = new BankAccount("00011", "Bob", 100);
        banksys.createAccount(baccount1);
        banksys.accountDetails();
        banksys.performtransaction("00011", "deposit",1500);
        //banksys.performDeposit(500);
        banksys.printStatement("00011");
        banksys.performtransaction("00011", "withdraw",500);
        banksys.printStatement("00011");



        BankAccount baccount2 = new BankAccount("00022", "Juliett", 100);
        banksys.createAccount(baccount2);
        banksys.accountDetails();
        banksys.performtransaction("00022", "deposit",1500);
        //banksys.performDeposit(500);
        //banksys.printStatement("00022");
        banksys.performtransaction("00022", "withdraw",500);
        banksys.printStatement("00022");

        System.out.println("\n");
        banksys.deleteAccount("00011");
        banksys.listAccounts();

    }
}
