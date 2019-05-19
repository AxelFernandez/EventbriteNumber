package com.axelfernandez;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * This test a strategy common method
 */
 public class AbstractStrategyTest {
    AbstractStrategy abstractStrategy = new HumanPcStrategy();

    /**
     * Test all variant of number
     */
    @Test
    public void validateNumber() {
        boolean result =  abstractStrategy.validateNumber("2314");
        Assert.assertTrue(result);

        result = abstractStrategy.validateNumber("1111");
        Assert.assertFalse(result);

        result = abstractStrategy.validateNumber("number");
        Assert.assertFalse(result);

        result = abstractStrategy.validateNumber("12345");
        Assert.assertFalse(result);
    }

    /**
     * Test a correct Number
     */
   @Test
   public void analyzeAttempt() {
        List result;
        int number = 1234;
        result = abstractStrategy.analyzeAttempt(number,1234);
        int goodResult = (Integer) result.get(0);
        int regularResult = (Integer) result.get(1);
        Assert.assertEquals(4,goodResult);
        Assert.assertEquals(0,regularResult);

   }


 }