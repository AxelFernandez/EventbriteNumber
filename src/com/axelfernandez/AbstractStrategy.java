package com.axelfernandez;

import java.util.Scanner;

/**
 * This class implement GameStrategy and just override one method default in all especific strategy
 * */

public abstract class AbstractStrategy implements GameStrategy {
    protected SecretNumber secretNumber;
    protected Integer attempt;
    protected Scanner scanner;

    public AbstractStrategy(){
        scanner = new Scanner(System.in);
        secretNumber = new SecretNumber();
    }

    /**
     * This method validate if is a correct number to guess
     * @param number
     * @return true if is valid
     */
    @Override
    public boolean validateNumber(String number) {
        boolean result = true;
        try {
            if (SecretNumber.isDigitRepeat(new Integer(number))){
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }
        if (number.length() != 4){
            result= false;
        }

        return result;
    }
    /**
     * This Method analyze the number
     * @param number
     */
    @Override
    public void analyzeAttempt(Integer number) {
        int goodAttempt = 0;
        int regularAttempt = 0;
        attempt = number;
        String secret =String.valueOf(secretNumber.getSecretNumber());
        for (int i =0; i<number.toString().length();i++){
            char iChar = number.toString().charAt(i);

            for (int j = 0; j<number.toString().length();j++){
                char jChar = secret.charAt(j);

                if (i==j && iChar == jChar){
                    goodAttempt++;
                }else if (iChar == jChar){
                    regularAttempt++;

                }

            }

        }

        System.out.println(goodAttempt+" Good "+regularAttempt+" Regular");

    }


}
