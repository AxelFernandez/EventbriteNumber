package com.axelfernandez;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractStrategyTest {
    AbstractStrategy abstractStrategy = new HumanPcStrategy();

    @Test
    void validateNumber() {
    boolean result =  abstractStrategy.validateNumber("2314");
    assertTrue(result);

    result = abstractStrategy.validateNumber("1111");
    assertFalse(result);

    result = abstractStrategy.validateNumber("number");
    assertFalse(result);

    result = abstractStrategy.validateNumber("12345");
    assertFalse(result);
    }

    @Test
    void analyzeAttempt() {
        List result;
       int number = abstractStrategy.secretNumber.getSecretNumber();
        result = abstractStrategy.analyzeAttempt(number);
        //assertArrayEquals(String [0,4] ,[0,4]);
    }
}