package OOP.SNAKE;

import java.util.*;

public class Main {
    public static void main(String[] args){
        int snakeEye = counter(6,13,100);

        System.out.println(snakeEye);


    }

    static int counter(int side1,int side2,int totalThrow){
        int count = 0;
        dice dice1 = new dice(side1);
        dice dice2 = new dice(side2);

        for (int i=0; i<= totalThrow; i++){
            dice1.roll();
            dice2.roll();

            if(dice1.getFaceValue() == 1 && dice2.getFaceValue() == 1) count++;
        }
        return count;
    }
}