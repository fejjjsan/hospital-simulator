package com.testapp.hospital.simulator.chance;

import java.util.Random;

public class OneInAMillionChance implements ChanceEvaluater {
    private static final int SUCCESS_VALUE = 10;
    private static final int MAX_VALUE = 1_000_000;
//    private final RandomInteger randomInteger;
    private final Random random;
    public OneInAMillionChance(Random random) {
        this.random = random;
    }
    /**
     * Simulates a one-in-a-million chance.
     * @return true if the random number matches SUCCESS_VALUE, otherwise false.
     */
    @Override
    public boolean isChanceOccurred() {
        return random.nextInt(MAX_VALUE) + 1 == SUCCESS_VALUE;
    }


}
