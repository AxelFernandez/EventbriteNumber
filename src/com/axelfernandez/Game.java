package com.axelfernandez;
/**
 * This class Start a game and gets a specific strategy to play
 * */
public class Game {

    GameStrategy gameStrategy;
    Boolean issolved;


    public Game(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }


    public void StartGame(){
        issolved = false;
        gameStrategy.StartGame();
        while (issolved==false){//infinite until is solved
            gameStrategy.sendAttempt();
            issolved = gameStrategy.isResult();
        }
    }
}
