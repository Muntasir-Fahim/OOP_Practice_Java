package cse.ku.oop;

public class BankSystem {
private BankAccount account;
private Transaction transaction[];
private BankAccount accountholders[]; //Account array for storing the bank accounts
private int currentIndex=0; //Pointer of accounts
private int tranCount = 0;
private int delCount = 0;

public BankSystem(int numberOfAccounts)
{
    this.accountholders = new BankAccount[numberOfAccounts];
    this.transaction = new Transaction[100];
}

public void addAccount(String number, String name, double initBalance){
    if(searchAccount(number) == null){
        BankAccount account = new BankAccount(number, name, initBalance);
        this.accountholders[currentIndex] = account; //Adding account object to array
        this.currentIndex++; //Increment the pointer
    }
    else System.out.println("Already created");
}

public void addTransaction(String number,String type, double amount){
    Transaction tran = new Transaction(number,type,amount);
    this.transaction[tranCount] = tran;
    this.tranCount++;
}

public BankAccount searchAccount(String number){
    for(int i = 0; i < currentIndex; i++){
        if(this.accountholders[i].getAccountNumber().equals(number)) {
            return this.accountholders[i]; //If found return the account object
        }
    }
    return null; //If account not found
}

public int getNumberOfCustomers(){
    return this.currentIndex;
}

public void createAccount(BankAccount account)
{
    this.account = account;
    System.out.println("Created account");
}


public void performtransaction(String number,String type, double amount)
{
    BankAccount acnt = searchAccount(number);
    if(acnt == null) {System.out.println("Account not found");return;};

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
    for(int i = 0; i < this.tranCount; i++)
    {
        if(this.transaction[i].getAccountNumber().equals(number))
        {
            System.out.println(this.transaction[i].getTransactionDetails());
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

public void deleteAccount(String accountNumber)
{
    for(int i = 0; i < currentIndex; i++){
        if(this.accountholders[i].getAccountNumber().equals(accountNumber))
        {
            this.accountholders[i] = null;
            System.out.println("Deleted " + accountNumber);
            for(int j = i; j < currentIndex-1; j++)
            {
                this.accountholders[j] = this.accountholders[j+1];
            }
            this.accountholders[currentIndex] = null;
            currentIndex--;
            this.delCount++;
            return;
        }
    }

    System.out.println(accountNumber + " does not exist");

}

public void listAccounts(){
    if(currentIndex==0){
        System.out.println("No accounts in the list");
        return;
    }
    System.out.println('\n' + "List of accounts: ");
    for(int i =0 ; i<currentIndex; i++)
    {
        System.out.println(this.accountholders[i].toString());
    }
}

}
