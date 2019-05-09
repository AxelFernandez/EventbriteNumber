package com.axelfernandez;

public class Game {

GameStrategy gameStrategy;

    public Game(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }


    public void analyze(int attempt){
        gameStrategy.analyceAttempt(attempt);
    }
}
