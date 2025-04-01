package com.testapp.hospital.simulator.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    public static String formatResult(List<String> diagnosisCodes) {
        int f = 0;
        int h = 0;
        int d = 0;
        int t = 0;
        int x = 0;
        for (String c : diagnosisCodes) {
            switch (c) {
                case "F" -> f++;
                case "H" -> h++;
                case "D" -> d++;
                case "T" -> t++;
                case "X" -> x++;
            }
        }
        return String.format("F:%d,H:%d,D:%d,T:%d,X:%d", f,h,d,t,x);
    }

     public static String buildStringFromInput(String[] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (i == input.length - 1) {
                sb.append(input[i]);
            } else {
                sb.append(input[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static String firstArgFromInput(String[] input) {
        return input[0];
    }
    public static String secondArgFromInput(String[] input) {
        return input[1];
    }
    public static boolean hasSecondArg(String[] args) {
        return args.length == 2;
    }

    public static List<String> argAsCodesList(String arg) {
        return Arrays.asList(arg.split(","));
    }

    public static String normalizeToUpperCase(String arg) {
        return arg.toUpperCase();
    }


}
