package com.techelevator.view;

import com.techelevator.Inventory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;



public class InventoryTest {
    Inventory itemName = new Inventory();

    public InventoryTest() throws FileNotFoundException {
    }

    @Test
    public void Inventory_NotA_Valid_Item_ReturnsFalse() throws FileNotFoundException {

        //arrange
        Inventory itemName = new Inventory();
        //act - methods
        Boolean result = itemName.isValidItem("z1");

        //assert
        Assert.assertFalse(result);
    }

}
