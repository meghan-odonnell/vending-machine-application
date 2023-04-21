package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private final VendingMenu menu;

    public VendingMachineCLI(VendingMenu menu) {
        this.menu = menu;
    }


    public void run() throws Exception {
        boolean running = true;
        Inventory runningInventory = new Inventory();
        runningInventory.restock();
        Money money = new Money();
        Logger logger = new Logger();

        while (running) {

            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                runningInventory.displayAll();

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                boolean whenPurchaseMenuRunning = true;
                while(whenPurchaseMenuRunning) {
                    String choice2nd = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);


                    if (choice2nd.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

                        money.intakeMoney();
                        logger.PrintToLog("FEED MONEY", money.getCurrentMoneyInput(), money.getBalance());
                        choice2nd = PURCHASE_MENU_OPTION_FEED_MONEY;
                    }

                    if (choice2nd.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        runningInventory.displayAll();
                        String currentSelection = menu.getItemSelection();

                        if (!runningInventory.isValidItem(currentSelection)) {
                            System.out.println("Learn to type!! dummy ");
                            continue;
                        }


                        BigDecimal currentPrice = runningInventory.getPrice(currentSelection);


                        if (runningInventory.isSoldOut(currentSelection)) {
                            System.out.println();
                            System.out.println(" ...................................  ");
                            System.out.println();
                            System.out.println("All gone! Pick something else.");
                            choice2nd = PURCHASE_MENU_OPTION_SELECT_PRODUCT;
                            continue;
                            }

                        if ((money.getBalance().compareTo(currentPrice) == -1)) {
                            System.out.println();
                            System.out.println(" ...................................  ");
                            System.out.println();
                            System.out.println("Awww you're out of money? :( broke ass bitch");
                        }
                        else {
                            runningInventory.updateQuantity(currentSelection);

                            runningInventory.getQuantity(currentSelection);
                            money.updateBalance(currentPrice);
                            System.out.println();
                            System.out.println(" ...................................  ");
                            System.out.println();
                            runningInventory.itemTypePrintOut(currentSelection);
                            System.out.println("You have $" + money.getBalance() + " remaining for snacks!");
                            System.out.println();
                            System.out.println(" ...................................  ");

                            logger.PrintToLog(runningInventory.Loginfo(currentSelection), runningInventory.getPrice(currentSelection), money.getBalance());
                        }

                        choice2nd = PURCHASE_MENU_OPTION_SELECT_PRODUCT;
                    }
                    if (choice2nd.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        BigDecimal finalBalance = money.getBalance();
                        System.out.println(" ...................................  ");
                        System.out.println();
                        System.out.println(money.giveChange());
                        System.out.println();
                        System.out.println(" ...................................  ");

                        logger.PrintToLog("GIVE CHANGE", finalBalance, money.getBalance());
                        choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
                        whenPurchaseMenuRunning = false;

                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                running = false;
            }

        }

    }

    public static void main(String[] args) throws Exception {

        VendingMenu menu = new VendingMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);

        System.out.println("Welcome to our vending machine Vendo-Matic 800!!!!!! ");
        cli.run();

    }

}

