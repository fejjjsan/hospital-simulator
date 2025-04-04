package com.testapp.hospital.simulator.random.integer;

import java.util.Random;

public class RandomIntegerFromOneToMillion implements RandomInteger {
    private static final int MAX_VALUE = 1_000_000;

    /**
     * Provides random int from 1 to 1_000_000.
     */
    @Override
    public int getRandomInteger() {
        var random = new Random();
        return random.nextInt(MAX_VALUE) + 1;
    }
}
