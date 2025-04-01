package com.testapp.hospital.simulator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OneInAMillionChance {
    private static final int SUCCESS_VALUE = 10;
    private static final int MAX_VALUE = 1_000_000;
    private static final Random RANDOM = new Random();

    /**
     * Simulates a one-in-a-million chance.
     * @return true if the random number matches SUCCESS_VALUE, otherwise false.
     */
    public static boolean chanceOccurred() {
        return RANDOM.nextInt(MAX_VALUE) + 1 == SUCCESS_VALUE;
    }
}
