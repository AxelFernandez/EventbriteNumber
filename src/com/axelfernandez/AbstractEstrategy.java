package com.axelfernandez;

import java.util.InputMismatchException;

public abstract class AbstractEstrategy implements GameStrategy {

    @Override
    public boolean validateNumber(String number) {
        boolean result = true;
        try {
            new Integer(number);
        } catch (InputMismatchException e) {
            result = false;
        }
        if (number.length() != 4){
            result= false;
        }

        return result;
    }
}
