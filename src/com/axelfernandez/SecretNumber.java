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

    private int getSecretNumber() {
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
        while (secretNumber < 1000){
            secretNumber = (int) (Math.random() * 9999);
        }
        return secretNumber;
    }

    protected List analyzeAttempt(int attempt){
        List result = new ArrayList();





        return result;
    }
}
