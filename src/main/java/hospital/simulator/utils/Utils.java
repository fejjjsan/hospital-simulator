package hospital.simulator.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class.getName());

    public static void formatResult(List<String> diagnosisCodes) {
        int f = 0, h = 0, d = 0, t = 0, x = 0;
        for (String c : diagnosisCodes) {
            switch (c) {
                case "F" -> f++;
                case "H" -> h++;
                case "D" -> d++;
                case "T" -> t++;
                case "X" -> x++;
            }
        }
        String result = String.format("F:%d,H:%d,D:%d,T:%d,X:%d", f,h,d,t,x);
        System.out.println(result);
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

     public static List<String> argAsСodesList(String arg) {
        return new ArrayList<>(Arrays.asList(arg.split(",")));
     }
}
