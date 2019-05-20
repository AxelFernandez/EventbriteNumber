package com.axelfernandez;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HumanPcStrategyTest {
    HumanPcStrategy humanPcStrategy = new HumanPcStrategy();

    /**
     * Test from mail
     */
    @Test
    public void findNextNumberCandidate() {
        List list = new ArrayList();
        list.add(1);
        list.add(1);
        int number = humanPcStrategy.findNextNumberCandidate(7234,list);
        assertEquals(7301,number);
    }

    @Test
    public void getValidNumber() {
        int number = humanPcStrategy.getValidNumber(10001);
        assertEquals(1234,number);
    }
}