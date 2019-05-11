package com.axelfernandez;


/**
 * This Factory create instances of especific strategy
 * */
public class FactoryStrategy {
    private static FactoryStrategy factoryStrategy;

    public static FactoryStrategy getInstance() {
        if (factoryStrategy == null){
            factoryStrategy = new FactoryStrategy();
        }
    return factoryStrategy;
    }

    public GameStrategy getGameStrategy(int option){
        GameStrategy result;
        if (option == 1){
           result = new PcHumanStrategy();
        }else if (option == 2){
            result = new HumanPcStrategy();
        }else{
            result = new PcHumanStrategy();
        }

        return result;
    }
}
