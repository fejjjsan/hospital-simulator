package hospital.simulator.validation;

import hospital.simulator.Drugs;
import hospital.simulator.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Slf4j
public class DrugNamesValidator implements Validator {
    private static final Logger logger = LoggerFactory.getLogger(DrugNamesValidator.class.getName());

    @Override
    public boolean validate(String input) {
        logger.debug("DRUG CODES: " + input);
        List<String> codes = Utils.argAsСodesList(input);
        var names = Drugs.getNames();
        return new HashSet<>(names).containsAll(codes);
    }
}
