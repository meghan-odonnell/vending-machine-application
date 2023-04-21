package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Money {

    Scanner currentMoneyInput = new Scanner(System.in);
    BigDecimal totalMoneyInput = new BigDecimal("0");
    BigDecimal currentFeed = new BigDecimal("0");
    int customerBalance = 0;


    public void intakeMoney()  {
        System.out.println(" ...................................  ");
        System.out.println();
        System.out.println("How much money would you like to add? ");
        boolean validMoney = false;
        do {
            customerBalance = Integer.valueOf(currentMoneyInput.nextLine());

            if (currentMoneyInput == null || customerBalance < 0) {
                validMoney = false;
                System.out.println(" ...................................  ");
                System.out.println();
                System.out.println("Can you not math?");
            } else {
                validMoney = true;
                totalMoneyInput = totalMoneyInput.add(BigDecimal.valueOf(customerBalance).setScale(2));
            }
        } while (!validMoney);
        System.out.println(" ...................................  ");
        System.out.println();
        System.out.println("You have entered = $" + totalMoneyInput);
    }

    public BigDecimal getCurrentMoneyInput() {
        currentFeed = BigDecimal.valueOf(customerBalance).setScale(2);
        return currentFeed;
    }

    public BigDecimal updateBalance(BigDecimal currentPrice) {
        totalMoneyInput = totalMoneyInput.subtract(currentPrice);
        return totalMoneyInput;
    }


    public BigDecimal getBalance() {
        return totalMoneyInput;
    }
    public String giveChange() {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while (totalMoneyInput.compareTo(BigDecimal.valueOf(.25)) == 1||totalMoneyInput.compareTo(BigDecimal.valueOf(.25)) == 0) {
            quarters++;
            totalMoneyInput = totalMoneyInput.subtract(BigDecimal.valueOf(.25));
        }
        while (totalMoneyInput.compareTo(BigDecimal.valueOf(.10)) == 1 || totalMoneyInput.compareTo(BigDecimal.valueOf(.10)) == 0) {
            dimes++;
            totalMoneyInput = totalMoneyInput.subtract(BigDecimal.valueOf(.10));
        }
        while (totalMoneyInput.compareTo(BigDecimal.valueOf(.05)) == 1 || totalMoneyInput.compareTo(BigDecimal.valueOf(.05)) == 0) {
            nickels++;
            totalMoneyInput = totalMoneyInput.subtract(BigDecimal.valueOf(.05));
        }
        String message = ("cha-ching! here is " + quarters + " quarters, " + dimes + " dimes, & " + nickels + " nickels.");
        return message;
        }

}