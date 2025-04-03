package com.testapp.hospital.simulator.validation;

import java.util.regex.Pattern;

public class RegexInputValidator implements ArgumentsValidator {

    /**
     * Pattern for validating input as string consisting of uppercase and lowercase letter sequences.
     * Format:
     * - A series of uppercase letters [A-Z], optionally separated by comma(s) if sequence is needed.
     * - Optionally, a space followed by another set of uppercase letters [A-Z]
     * where each MAY have a single lowercase [a-z] letter, optionally separated by comma(s) if sequence is needed.
     * Valid examples:
     * - "D"
     * - "D,F"
     * - "D,F A"
     * - "D,F,F An,As"
     * Invalid examples:
     * - "D, F" (extra space after comma)
     * - "D,," (double comma)
     * - "D,F A " (extra space at the end)
     * - "D,F A, An" (extra space after comma in the second section)
     */
    private static final Pattern PATTERN =
            Pattern.compile("^[A-Z](,[A-Z])*( [A-Z][a-z]?(,[A-Z][a-z]?)*)?$");

    @Override
    public boolean validate(String string) {
        return PATTERN.matcher(string).matches();
    }

}
