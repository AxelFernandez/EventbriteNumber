package com.axelfernandez;

public class Game {

    GameStrategy gameStrategy;
    Boolean issolved;


    public Game(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }




    public void StartGame(){
        issolved = false;
        gameStrategy.StartGame();
        while (issolved==false){
            gameStrategy.sendAttempt();
            issolved = gameStrategy.isresult();


        }

    }
}
