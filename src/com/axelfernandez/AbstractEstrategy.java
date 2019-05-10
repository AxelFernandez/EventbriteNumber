package com.axelfernandez;

import java.util.InputMismatchException;

public abstract class AbstractEstrategy implements GameStrategy {

    @Override
    public boolean validateNumber(String number) {
        boolean result = true;
        try {
            if (SecretNumber.isDigitRepeat(new Integer(number))){
                result = false;
            }
        } catch (InputMismatchException e) {
            result = false;
        }
        if (number.length() != 4){
            result= false;
        }

        return result;
    }
}
