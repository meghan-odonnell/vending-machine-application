package com.techelevator;

import java.util.Scanner;

public interface TransactionInterface {

    Scanner customerMoney = new Scanner(System.in);




//        System.out.println("How much money would you like to add? ");

        int customerBalance = Integer.valueOf(customerMoney.nextLine());

//        System.out.println("You have entered = " + customerBalance);



}
