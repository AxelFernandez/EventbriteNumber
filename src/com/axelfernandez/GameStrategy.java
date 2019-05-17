package com.axelfernandez;

import java.util.List;

/**
 * Interface with all step must be applied in different algorithm
 * */
public interface GameStrategy {

    void StartGame();

    List analyzeAttempt(Integer number);

    void sendAttempt();

    boolean isResult();

    boolean validateNumber(String number);

}
