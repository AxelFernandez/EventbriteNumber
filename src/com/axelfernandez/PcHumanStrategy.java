package com.axelfernandez;


import java.util.ArrayList;
import java.util.List;

public class PcHumanStrategy implements GameStrategy {


    @Override
    public List analyceAttempt(int attempt) {
        List result = new ArrayList();
        result.add("pc humano test");
        System.out.println("PC humano test");
        return  result;
    }
}
