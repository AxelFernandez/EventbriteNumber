package com.axelfernandez;


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

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }
    public void setSecretNumber(){
        this.setSecretNumber(getRandomNumber());
    }
    /**
     * Get a four cifres number, and validate
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

    /**
     * This method put a number in test, fist if is less than 1000 and after if the digit is not repeat
     * @param secretNumber that came from the getRandomNumber()
     * @return true if it pass all the test
     */
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

    /**
     * Static method, this validate if the number repeat a digit
     * @param number
     * @return true if repeat, false if all digit are diferent.
     */
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
