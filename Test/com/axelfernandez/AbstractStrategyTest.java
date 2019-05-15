package com.axelfernandez;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractStrategyTest {

    @Test
    void validateNumber() {
    AbstractStrategy abstractStrategy = new HumanPcStrategy();
    boolean result =  abstractStrategy.validateNumber("2312");
    assertTrue(result);

    result = abstractStrategy.validateNumber("1111");
    assertFalse(result);
    }

    @Test
    void analyzeAttempt() {
    }
}