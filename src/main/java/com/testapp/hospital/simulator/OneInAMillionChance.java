package com.testapp.hospital.simulator;

import com.testapp.hospital.simulator.random.integer.RandomInteger;

public class OneInAMillionChance implements ChanceEvaluater {
    private static final int SUCCESS_VALUE = 10;
    private final RandomInteger randomInteger;

    public OneInAMillionChance(RandomInteger randomInt) {
        this.randomInteger = randomInt;
    }
    /**
     * Simulates a one-in-a-million chance.
     * @return true if the random number matches SUCCESS_VALUE, otherwise false.
     */
    @Override
    public boolean test() {
        return randomInteger.getRandomInteger() == SUCCESS_VALUE;
    }


}
