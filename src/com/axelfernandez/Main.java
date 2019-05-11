package com.axelfernandez;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Eventbrite Test, Take a option. \n 1- Human vs PC \n 2- Pc vs Human ");
        Scanner scanner = new Scanner(System.in);
        int optionStrategy = scanner.nextInt();
        Game game = new Game(FactoryStrategy.getInstance().getGameStrategy(optionStrategy));
        game.StartGame();

    }
}
