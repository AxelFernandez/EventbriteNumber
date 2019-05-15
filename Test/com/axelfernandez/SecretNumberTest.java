package com.axelfernandez;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecretNumberTest {

    @Test
    void isDigitRepeat() {
        boolean result = SecretNumber.isDigitRepeat(2314);
        assertFalse(result);

        result = SecretNumber.isDigitRepeat(2222);
        assertTrue(result);
    }
}