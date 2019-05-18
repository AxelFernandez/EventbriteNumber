package com.axelfernandez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *This is the strategy when the human think a number and Pc try to figured it.
 */
public class HumanPcStrategy extends AbstractStrategy {
    private boolean isvalidNumber;
    Map<Integer,List> candidateMap;
    SecretNumber tryNumber ;
    int attemptNumber = 0;
    List attempt;

    /**
     * Human think a number and save it in a SecretNumber object
     */
    @Override
    public void StartGame() {
        tryNumber = new SecretNumber();
        candidateMap = new HashMap<>();
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
            attempt = analyzeAttempt(secretNumber.getSecretNumber());
            System.out.println(attempt.get(0)+" Good "+attempt.get(1)+" Regular");
            System.out.println("Attempt number: "+ attemptNumber);
        }

    }

    /**
     * Validate if the number generated is correct
     * @return true if is correct, and the game over.
     */
    @Override
    public boolean isResult() {

    }

    /**
     * Gets a valid number, if it was tried, take another
     * @return
     */
    private int thinkNumber(List feedback){

    }




}
