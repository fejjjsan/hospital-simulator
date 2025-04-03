package com.testapp.hospital.simulator.validation;

import com.testapp.hospital.simulator.diagnosis.DiagnosisType;
import com.testapp.hospital.simulator.utils.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiagnosesNamesValidator implements ArgumentsValidator {

    private static final Set<String> diagnosisCodes = new HashSet<>(DiagnosisType.getNames());

    @Override
    public boolean validate(String input) {
        List<String> codes = Utils.argAsCodesList(input);
        return diagnosisCodes.containsAll(codes);
    }
}
