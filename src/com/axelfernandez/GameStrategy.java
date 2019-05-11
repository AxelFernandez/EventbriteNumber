package com.axelfernandez;

import java.util.List;

/**
 * Interface with all step must be aplicated in different algoritmic
 * */
public interface GameStrategy {

    void StartGame();

    void analyzeAttempt(Integer number);

    void sendAttempt();

    boolean isResult();

    boolean validateNumber(String number);

}
