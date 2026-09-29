package OOP;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Account nayem;
        nayem = new Account("260254","Naim","Current",1000);

        nayem.deposit(700);
        nayem.withdraw(500);

        Account rafiq = new Account("260257","Rafiq","Current",1000);
        rafiq.deposit(300);

        //performing delete operation
        Account.removeAccount("260257");

        Account karim = new Account("260258","Karim","Current",2400);
        nayem.withdraw(500);

        for (Account u : Account.getAccountList()){
            System.out.println(u.getAccountDetails());
        }

        System.out.println("\nTransaction of Nayem");

        for (Transaction u : nayem.getTranList()){
            System.out.println(u.getTransactionDetails());
        }



    }

}