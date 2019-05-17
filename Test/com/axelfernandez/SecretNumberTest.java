package com.axelfernandez;


import org.junit.Assert;
import org.junit.Test;

public class SecretNumberTest {

   @Test
   public void isDigitRepeat() {
        boolean result = SecretNumber.isDigitRepeat(2314);
       Assert.assertFalse(result);

        result = SecretNumber.isDigitRepeat(2222);
       Assert.assertTrue(result);
    }
}