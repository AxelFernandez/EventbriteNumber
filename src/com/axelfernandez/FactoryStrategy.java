package com.axelfernandez;

public class FactoryStrategy {
    private static FactoryStrategy factoryStrategy;

    public static FactoryStrategy getInstance() {
        if (factoryStrategy == null){
            factoryStrategy = new FactoryStrategy();
        }
    return factoryStrategy;
    }

    public GameStrategy getGameStrategy(int option){
        GameStrategy result = null;
        if (option == 1){
           result = new PcHumanStrategy();
        }

        return result;
    }
}
