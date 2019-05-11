package com.axelfernandez;

import java.util.ArrayList;
import java.util.List;

/**
 *This is the strategy when the human think a number and Pc try to figured it.
 */
public class HumanPcStrategy extends AbstractStrategy {
    private boolean isvalidNumber;
    List <Integer> triedNumbers;
    SecretNumber tryNumber ;
    int attemptNumber = 0;


    /**
     * Human think a number and save it in a SecretNumber object
     */
    @Override
    public void StartGame() {
        tryNumber = new SecretNumber();
        triedNumbers = new ArrayList();
        isvalidNumber = false;
        System.out.println("Write a number with four digit, and no repeat it");
        String number = scanner.next();
        if (validateNumber(number)){
            secretNumber.setSecretNumber(new Integer(number));
            isvalidNumber = true;
        }else {
            System.out.println("Invalid number!");
        }
    }

    /**
     * This Method with an algorithm try at guess the secreted number only if isvalidNumber is true
     */
    @Override
    public void sendAttempt() {
        if (isvalidNumber){
            analyzeAttempt(thinkNumber());
            System.out.println("Attempt number: "+ attemptNumber);
        }

    }

    /**
     * Validate if the number generated is correct
     * @return true if is correct, and the game over.
     */
    @Override
    public boolean isResult() {
        boolean result =false;
        System.out.println("Number Generated" + tryNumber.getSecretNumber());
        System.out.println("-----------------------------");
        if (isvalidNumber && secretNumber.getSecretNumber() == tryNumber.getSecretNumber()){
            result = true;
        }else {
            triedNumbers.add(tryNumber.getSecretNumber());
            attemptNumber++;
        }

        return result;
    }

    /**
     * Gets a valid number, if it was tried, take another
     * @return
     */
    private int thinkNumber(){
        boolean isvalid = false;
        int result = 0;
        while (isvalid==false){
            if (triedNumbers.isEmpty()){
                result = tryNumber.getSecretNumber();
                isvalid = true;
            }
            for (Integer element : triedNumbers){
                if (element.equals(tryNumber.getSecretNumber())){
                    tryNumber.setSecretNumber();
                    result = tryNumber.getSecretNumber();
                }else{
                    isvalid= true;
                    result = tryNumber.getSecretNumber();
                }

            }

        }
        return result;
    }




}
