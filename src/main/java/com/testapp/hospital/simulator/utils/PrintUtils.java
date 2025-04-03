package com.testapp.hospital.simulator.utils;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PrintUtils {

    public static void printResultOfTreatment(String result) {
        System.out.println(result);
    }

    public static void printNoInputProvided() {
        System.out.println("Error: No input provided");
    }

    public static void printWrongInputFormat() {
        System.out.println("Wrong input format!");
    }

    public static void printValidArgumentsPattern() {
        var string = """
                Input should have one of this formats:
                "D"
                "D,F"
                "D,F A"
                "D,F,F An,As"
                """;
        System.out.println(string);
    }

}
