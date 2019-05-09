package com.axelfernandez;

import java.util.List;

public interface GameStrategy {

    void StartGame();

    void analyceAttempt(Integer number);

    void sendAttempt();

    boolean isresult();

    boolean validateNumber(String number);

}
