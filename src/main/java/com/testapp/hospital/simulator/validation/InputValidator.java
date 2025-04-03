package com.testapp.hospital.simulator.validation;

import com.testapp.hospital.simulator.utils.PrintUtils;
import com.testapp.hospital.simulator.utils.Utils;
import lombok.Builder;


@Builder
public class InputValidator {

    private ArgumentsValidator regexInputArgumentsValidator;
    private ArgumentsValidator diagnosesNamesArgumentsValidator;
    private ArgumentsValidator drugNamesArgumentsValidator;

    public boolean validateInput(String[] input) {
        var length = input.length;

        if (length == 0) {
            PrintUtils.printNoInputProvided();
            return false;
        }

        if (!validateInputAgainstRegex(input)) {
            PrintUtils.printWrongInputFormat();
            PrintUtils.printValidArgumentsPattern();
            return false;
        }


        return validateFirstParameter(input) && validateSecondParameter(input);
    }

    private boolean validateInputAgainstRegex(String[] input) {
        var string = Utils.buildStringFromInput(input);
        return regexInputArgumentsValidator.validate(string);
    }

    private boolean validateFirstParameter(String[] input) {
        var arg = Utils.firstArgFromInput(input);
        return diagnosesNamesArgumentsValidator.validate(arg);
    }

    private boolean validateSecondParameter(String[] input) {
        if (!Utils.hasSecondArg(input)) return true;
        var arg = Utils.secondArgFromInput(input);
        var argNormalized = Utils.normalizeToUpperCase(arg);
        return drugNamesArgumentsValidator.validate(argNormalized);
    }

}
