package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String itemName;
    private BigDecimal price;
    private String itemType;
    private int quantity;



    public Item(String itemName, BigDecimal price, String itemType, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getItemType() {

        return itemType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
