package com.axelfernandez;

import java.util.List;

/**
 *This is the strategy when the human think a number and Pc try to figured it.
 */
public class HumanPcStrategy extends AbstractStrategy {
    private boolean isvalidNumber;
    SecretNumber tryNumber ;
    boolean isresult = false;
    List attempt;

    /**
     * Human think a number and save it in a SecretNumber object
     */
    @Override
    public void StartGame() {
        tryNumber = new SecretNumber();
        isvalidNumber = false;
        System.out.println("Write a number with four digit, and no repeat it");
        String number = scanner.next();
        if (validateNumber(number)){
            secretNumber.setSecretNumber(new Integer(number));
            isvalidNumber = true;
            attempt = analyzeAttempt(tryNumber.getSecretNumber(),secretNumber.getSecretNumber());
        }else {
            System.out.println("Invalid number!");
            StartGame();
        }
    }

    /**
     * This Method with an algorithm try at guess the secreted number only if isvalidNumber is true
     */
    @Override
    public void sendAttempt() {
        if (isvalidNumber){
            int nextNumber  = thinkNumber(tryNumber.getSecretNumber(), attempt);
            tryNumber.setSecretNumber(nextNumber);
            attempt = analyzeAttempt(tryNumber.getSecretNumber(),secretNumber.getSecretNumber());

        }
    }

    /**
     * Validate if the number generated is correct
     * @return true if is correct, and the game over.
     */
    @Override
    public boolean isResult() {
       if (!isresult){
           String responseCheck= attempt.get(0) +","+attempt.get(1);
           System.out.println("We try "+ tryNumber.getSecretNumber()+" and we recommend this from the number "+ secretNumber.getSecretNumber());
           System.out.println(attempt.get(0)+" Good "+attempt.get(1)+" Regular");
           System.out.println("Type "+responseCheck);
           AnswerCheck(responseCheck);
           System.out.println("-----------------------------------------------------");
       }else {
           System.out.println("I Win!");
       }
       return isresult;
    }


    private void AnswerCheck(String responseCheck){
        String response = scanner.next();
        if (!response.equals(responseCheck)){
            System.out.println("Wrong Answer try again");
            AnswerCheck(responseCheck);

        }


    }
    /**
     * Evaluate a number to try
     * @return A number to add in object tryNumber
     */
    protected int thinkNumber(int number,List<Integer> feedback){
        int result = 0;
        if (!feedback.get(0).equals(4)){
            result = findNextNumberCandidate(number,feedback);
        }else{
            isresult = true;
        }

    return result;
    }

    /**
     * Find a new Number to try, also validate with the last number tried
     * @param number Last number tried
     * @param feedback List with the correct and regular attempt, index 0 for Good Attempt, index 1 for Regular Attempt
     * @return next number to try
     */
    protected int findNextNumberCandidate(int number, List feedback){
        Integer nextNumber = number;
        boolean isValidateCandidate = false;
        int goodAttempt = (Integer) feedback.get(0);
        int regularAttempt = (Integer) feedback.get(1);

        while (!isValidateCandidate){
            nextNumber = getValidNumber(nextNumber +1);
            List nextNumberFeedback = analyzeAttempt(number,nextNumber);
            int goodAttemptfeedback = (int) nextNumberFeedback.get(0);
            int regularAttemptfeedback = (int) nextNumberFeedback.get(1);
            if (goodAttempt == goodAttemptfeedback && regularAttempt == regularAttemptfeedback){
                isValidateCandidate=true;
            }else{
                nextNumber++;
            }
        }
        return nextNumber;
    }

    /**
     * Return a valid number, if isn't valid, try with the next, if number is more than 9999, it return to 1234
     * @param number number validate
     * @return same number or the next
     */
    protected int getValidNumber(Integer number){
        Integer result = number;
        if (!validateNumber(number.toString())){
            if (number>9999) {
                result = 1234;
                return result;
            }
            return getValidNumber(result + 1);
        }else{
            return result;
        }
    }





}
