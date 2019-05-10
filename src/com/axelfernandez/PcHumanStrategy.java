package com.axelfernandez;



import java.util.Scanner;

/**
 * In this class the Pc think a number, and the Human must guess the number
 * */
public class PcHumanStrategy extends AbstractEstrategy {

    SecretNumber secretNumber;
    Integer attempt;
    Scanner scanner;
    public PcHumanStrategy() {
        scanner = new Scanner(System.in);
    }

    /**
    *This method generate a Random Number
    **/
    @Override
    public void StartGame() {
        secretNumber = new SecretNumber();
        System.out.println("Random number is generated, Try one");
    }

    @Override
    public void analyceAttempt(Integer number) {
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

    @Override
    public void sendAttempt() {
        String attempt = scanner.next();
        if (validateNumber(attempt)){
            analyceAttempt(new Integer(attempt));

        }else{
            System.out.println("Invalid Number!");
        }

    }

    @Override
    public boolean isresult() {
        boolean result = false;
        if (attempt != null){
            if (attempt == secretNumber.getSecretNumber()){
                result = true;
            }
        }
        return result;
    }
}
