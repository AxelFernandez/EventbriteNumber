package com.axelfernandez;


import org.junit.Assert;
import org.junit.Test;


public class FactoryStrategyTest {

    @Test
    public void getGameStrategy() {
        GameStrategy gameStrategy = FactoryStrategy.getInstance().getGameStrategy(1);
        Assert.assertTrue(gameStrategy instanceof PcHumanStrategy);

        gameStrategy = FactoryStrategy.getInstance().getGameStrategy(2);
        Assert.assertTrue(gameStrategy instanceof HumanPcStrategy);
    }
}
