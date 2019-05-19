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
        String number = scanner.next();//TODO: what if stay a 4 cifres number
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
            while (attempt.get(0).equals(0) && candidateMap.isEmpty()){
                tryNumber.setSecretNumber();
                attempt = analyzeAttempt(tryNumber.getSecretNumber(),secretNumber.getSecretNumber());
            }
            // scanner.next();
            int nextNumber  = thinkNumber(tryNumber.getSecretNumber(), attempt);
            candidateMap.put(nextNumber,attempt);
            tryNumber.setSecretNumber(nextNumber);
            System.out.println("We try "+ tryNumber.getSecretNumber()+" and we recommend this from the number "+ secretNumber.getSecretNumber()+" press enter to continue");
            System.out.println(attempt.get(0)+" Good "+attempt.get(1)+" Regular");
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
        if (candidateMap.isEmpty()) {
            result =number;
        }else if (!feedback.get(0).equals(4)){
            result = findNextNumberCandidate(number,feedback);
        }else{
            System.out.println("You Win!");
            isresult = true;
        }

    return result;
    }

    private int findNextNumberCandidate(int number, List feedback){
        Integer nextNumber = number + 1;
        boolean isValidateCandidate = false;
        int goodAttempt = (Integer) feedback.get(0);
        int regularAttempt = (Integer) feedback.get(1);

        while (!isValidateCandidate){
            while (!validateNumber(nextNumber.toString())){
                nextNumber++;
            }
            //nextNumber++;
            if (nextNumber>9999){
                nextNumber= 1234;
            }
            List nextNumberFeedback = analyzeAttempt(number,nextNumber);
            int goodAttemptfeedback = (int) nextNumberFeedback.get(0);
            int regularAttemptfeedback = (int) nextNumberFeedback.get(1);

            if (goodAttempt == goodAttemptfeedback && regularAttempt == regularAttemptfeedback){
                isValidateCandidate = validateCandidate(nextNumber);

            }else{
                nextNumber++;
            }
        }
        return nextNumber;
    }

    private boolean validateCandidate(int number){
        boolean result = true;
        for (Map.Entry<Integer, List> entry : candidateMap.entrySet()) {

            List candidateFeedback = analyzeAttempt(number,entry.getKey());
            Integer goodAttempt =(Integer) candidateFeedback.get(0);
            Integer regularAttempt =(Integer) candidateFeedback.get(1);
            if (!goodAttempt.equals(entry.getValue().get(0)) && !regularAttempt.equals(entry.getValue().get(1)) && candidateMap.size()>1){
                result = false;
            }


        }

        return result;

    }

    private boolean containNumber(int number){
        boolean result = false;

        for (Map.Entry<Integer, List> entry : candidateMap.entrySet()) {
            if (entry.getKey().equals(number)) {
                result= true;
            }
        }
        return result;
    }

}
