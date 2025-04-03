package com.testapp.hospital.simulator.validation;

import com.testapp.hospital.simulator.Drugs;
import com.testapp.hospital.simulator.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class DrugNamesValidator implements ArgumentsValidator {
    private static final Set<String> drugCodes = new HashSet<>(Drugs.getNames());

    @Override
    public boolean validate(String input) {
        if (input.isEmpty()) {
            return true;
        }
        List<String> codesFromInput = Utils.argAsCodesList(input);
        return drugCodes.containsAll(codesFromInput);
    }
}
