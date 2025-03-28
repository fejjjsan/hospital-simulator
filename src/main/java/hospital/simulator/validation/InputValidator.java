package hospital.simulator.validation;

import hospital.simulator.utils.Utils;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Builder
public class InputValidator {

    private static final Logger logger = LoggerFactory.getLogger(InputValidator.class.getName());

    private Validator regexInputValidator;
    private Validator diagnosesNamesValidator;
    private Validator drugNamesValidator;

    public boolean validateInput(String[] input) {
        var length = input.length;
        if (!validateInputAgainstRegex(input)) return false;
        switch (length) {
            case 1 -> {
                return validateFirstParameter(input);
            }
            case 2 -> {
                return validateFirstParameter(input) && validateSecondParameter(input);
            }
            default -> {
                return false;
            }
        }

    }
    private boolean validateInputAgainstRegex(String[] input) {
        var string = Utils.buildStringFromInput(input);
        return regexInputValidator.validate(string);
    }

    private boolean validateFirstParameter(String[] input) {
        String firstParam = Utils.firstArgFromInput(input);
        return diagnosesNamesValidator.validate(firstParam);
    }

    private boolean validateSecondParameter(String[] input) {
        String secondParam = Utils.secondArgFromInput(input);
        return drugNamesValidator.validate(secondParam);
    }

}
