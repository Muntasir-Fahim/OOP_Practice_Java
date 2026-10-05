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

        Account karim = new Account("260258","Karim","Current",2400);
        karim.withdraw(500);

        if(!Account.removeAccount("260257")) {
            System.out.println("Not found");   ;
        }

        //Account list
        for (Account u : Account.getAccountList()){
            System.out.println(u.getAccountDetails());
        }

        Account.showTransactions("260255");



    }

}