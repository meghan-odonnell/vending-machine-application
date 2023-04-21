package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Inventory {


    File inputFile = new File("C:\\Users\\Student\\workspace\\nlr-12-module-1-capstone-team-7\\vendingmachine.csv"); //now file is here in the try
    Scanner reader = new Scanner(inputFile);
    Map<String, Item> inventory = new HashMap<String, Item>();

    String slot;

    BigDecimal itemPrice = new BigDecimal("0");

    public Inventory() throws FileNotFoundException {
    }

    public void restock() {
        while (reader.hasNextLine()) {

            String inventoryLine = reader.nextLine();
            String inventoryLineReplaced = inventoryLine.replace("|", ",");
            String[] inventoryArray = inventoryLineReplaced.split(",");
            String stringItemPrice = inventoryArray[2];
            inventory.put(inventoryArray[0], new Item(inventoryArray[1], new BigDecimal(stringItemPrice), inventoryArray[3], 5));
        }

    }

    public void displayAll() {
        for (Map.Entry<String, Item> inventoryItem : inventory.entrySet()) {

            String itemSlot = inventoryItem.getKey();
            String itemName = inventoryItem.getValue().getItemName();
            BigDecimal itemPrice = inventoryItem.getValue().getPrice();
            String itemType = inventoryItem.getValue().getItemType();
            int itemQuantity = inventoryItem.getValue().getQuantity();

            System.out.println(
                    inventoryItem.getKey() + "|" + itemName + "|" + itemPrice + "|" + itemType + "|" + itemQuantity);
        }
    }

    public BigDecimal getPrice(String slot) {
        return inventory.get(slot).getPrice();
    }

    public int getQuantity(String slot) {
        return inventory.get(slot).getQuantity();
    }

    public boolean isSoldOut(String slot) {
        boolean isSoldOut = false;
        if (getQuantity(slot) > 0) {
            return isSoldOut;
        } else isSoldOut = true;
        return isSoldOut;
    }

    public boolean isValidItem(String slot) {
        boolean isValidItem = false;
        if (!inventory.containsKey(slot)) {
           return false;
        }
        isValidItem = true;
        return true;
    }

    public void updateQuantity(String slot) {
        int newQuantity = inventory.get(slot).getQuantity() - 1;
        inventory.get(slot).setQuantity(newQuantity);
    }

    public void itemTypePrintOut(String slot) {
        String checkingInventory = inventory.get(slot).getItemType();
        System.out.println(inventory.get(slot).getItemName() + ": $" + getPrice(slot));
        if (checkingInventory.equals("Chip")) {
            System.out.println("Crunch Crunch, It's Yummy!");
        } else if (checkingInventory.equals("Candy")) {
            System.out.println("Munch Munch, Mmm Mmm Good!");
        } else if (checkingInventory.equals("Drink")) {
            System.out.println("Glug Glug, Chug Chug!");
        } else if (checkingInventory.equals("Gum")) {
            System.out.println("Chew Chew, Pop!");
        }
    }

    public String Loginfo(String slot) {
        String logInfo = inventory.get(slot).getItemName() + " " + slot;
        return logInfo;
    }

}








