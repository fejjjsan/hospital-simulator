package hospital.simulator.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class RegexInputValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(RegexInputValidator.class.getName());
    private static final Pattern PATTERN =
            Pattern.compile("^[A-Z](,[A-Z])*( [A-Z][a-z]?(,[A-Z][a-z]?)*)?$");

    @Override
    public boolean validate(String string) {
        return PATTERN.matcher(string).matches();
    }

}
