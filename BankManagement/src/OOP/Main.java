package OOP;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Account nayem;
        nayem = new Account("260254","Naim","Current",1000);
//        nayem.setNumber();
//        nayem.setUserName();
//        nayem.setType();
//        nayem.setBalance();

        nayem.deposit(700);
        nayem.withdraw(500);

        Account rafiq = new Account("260257","Rafiq","Current",1000);
        rafiq.deposit(300);


    }

}