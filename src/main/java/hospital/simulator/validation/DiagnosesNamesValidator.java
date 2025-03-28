package hospital.simulator.validation;

import hospital.simulator.diagnosis.DiagnosisType;
import hospital.simulator.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;

public class DiagnosesNamesValidator implements Validator {
    private static final Logger logger = LoggerFactory.getLogger(DrugNamesValidator.class.getName());

    @Override
    public boolean validate(String input) {
        List<String> codes = Utils.argAsСodesList(input);
        var names = DiagnosisType.getNames();
        return new HashSet<>(names).containsAll(codes);
    }
}
