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
    boolean isresult = false;
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
            attempt = analyzeAttempt(tryNumber.getSecretNumber(),secretNumber.getSecretNumber());
            while (attempt.get(0).equals(0)){
                tryNumber.setSecretNumber();
                attempt = analyzeAttempt(tryNumber.getSecretNumber(),secretNumber.getSecretNumber());
            }
            System.out.println("We try "+ tryNumber.getSecretNumber()+" and we recommend this from the number "+ secretNumber.getSecretNumber()+" press enter to continue");
            System.out.println(attempt.get(0)+" Good "+attempt.get(1)+" Regular");
            // scanner.next();
            tryNumber.setSecretNumber(thinkNumber(tryNumber.getSecretNumber(),attempt));
        }
    }

    /**
     * Validate if the number generated is correct
     * @return true if is correct, and the game over.
     */
    @Override
    public boolean isResult() {
       return isresult;
    }

    /**
     * Gets a valid number, if it was tried, take another
     * @return
     */
    private int thinkNumber(int number,List<Integer> feedback){
        int result = 0;
        if (!feedback.get(0).equals(4)){
            candidateMap.put(number,feedback);
            result = findNextNumberCandidate(number,feedback.get(0));
        }else{
            isresult = true;
        }


    return result;
    }

    private int findNextNumberCandidate(int number, int goodAttempt){
        int result = 0;
        int nextNumber = 0;
        while (goodAttempt != result){
            nextNumber = number++;
            if (nextNumber<9999){
                nextNumber = 1234;
            }
            List nextNumberFeedback = analyzeAttempt(number,nextNumber);
            result = (int) nextNumberFeedback.get(0);

        }
        if (validateCandidate(nextNumber)){
            result = 1234;
        }
        System.out.println(result);


        return result;
    }

    private boolean validateCandidate(int number){
        boolean result = false;
        for (Map.Entry<Integer, List> entry : candidateMap.entrySet()) {

            List candidateFeedback = analyzeAttempt(number,entry.getKey());

            if (candidateFeedback.get(0).equals(entry.getValue().get(0))){
                result = true;
            }


        }

        return result;

    }



}
