package com.axelfernandez;

import java.util.ArrayList;
import java.util.List;

/**
 * This class get a Random Number
 */
public class SecretNumber {

    private int secretNumber;

    public SecretNumber() {
        this.secretNumber = getRandomNumber();
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    private void setSecretNumber() {
        this.secretNumber = getRandomNumber();
    }

    /**
     * Get a four cifres number, if the number is less than 1000, it call herself again
     * @return number in range from 1000 to 9999
     */
    private int getRandomNumber(){
        int secretNumber= 0;
        boolean isValidated = false;
        while (isValidated == false){
            secretNumber = (int) (Math.random() * 9999);
            isValidated = validateNumber(secretNumber);
        }
        return secretNumber;
    }

    private boolean validateNumber(Integer secretNumber){
        boolean result = true;
        if (secretNumber < 1000){
            result = false;
        }
        if (isDigitRepeat(secretNumber)){
            result = false;

        }

        return result;
    }
    
    public static boolean isDigitRepeat(Integer number){
        boolean result = false;
        for (int i =0; i<number.toString().length();i++) {
            char iChar = number.toString().charAt(i);
            for (int j = 0; j < number.toString().length(); j++) {
                char jChar = number.toString().charAt(j);
                if (i != j && iChar == jChar) {
                    result = true;

                }

            }
        }

        return result;

    }


}
