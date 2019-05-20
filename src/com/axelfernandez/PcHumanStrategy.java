package com.axelfernandez;


import java.util.List;

/**
 * In this class the Pc think a number, and the Human must guess the number
 * */
public class PcHumanStrategy extends AbstractStrategy {

    /**
    *This method generate a Random Number
    **/
    @Override
    public void StartGame() {
        System.out.println("Random number is generated, Try one");
    }


    /**
     * Recive a attempt and call analyzeAttempt()
     * attempt index 0 = Good
     * Attempt index 1 = Regular
     */
    @Override
    public void sendAttempt() {
        String attempt = scanner.next();
        if (validateNumber(attempt)){
           List attemptList = analyzeAttempt(new Integer(attempt),secretNumber.getSecretNumber());
            System.out.println(attemptList.get(0)+" Good "+attemptList.get(1)+" Regular");

        }else{
            System.out.println("Invalid Number!");
        }
    }

    /**
     * Validate the attempt if is the same in the SecretNumber
     * @return
     */
    @Override
    public boolean isResult() {
        boolean result = false;
        if (attempt != null){
            if (attempt == secretNumber.getSecretNumber()){
                result = true;
            }
        }
        return result;
    }
}
