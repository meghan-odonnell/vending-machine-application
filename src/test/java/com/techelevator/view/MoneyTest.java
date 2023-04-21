package com.techelevator.view;

import com.techelevator.Money;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class MoneyTest {
    @Test
    public void Update_Balance_Returns_Correct() {
        Money money = new Money();

        BigDecimal result = money.updateBalance(BigDecimal.valueOf(1.75));

        Assert.assertEquals(BigDecimal.valueOf(-1.75), result);
    }





}
