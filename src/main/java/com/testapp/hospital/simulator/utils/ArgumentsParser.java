package com.testapp.hospital.simulator.utils;

import com.testapp.hospital.simulator.Drugs;
import com.testapp.hospital.simulator.diagnosis.Diagnosis;
import com.testapp.hospital.simulator.diagnosis.DiagnosisFactory;
import com.testapp.hospital.simulator.diagnosis.DiagnosisType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArgumentsParser {

    private static final String EMPTY_ARGUMENT = "";

    public static Set<Drugs> drugsListFromArgument(String[] args) {
        Set<Drugs> result = new TreeSet<>();
        String arg = Utils.hasSecondArg(args) ? Utils.secondArgFromInput(args) : EMPTY_ARGUMENT;

        if (arg.isEmpty()) {
            return result;
        }

        String argNormalized = Utils.normalizeToUpperCase(arg);
        List<String> drugsList = Utils.argAsCodesList(argNormalized);

        for (String drug : drugsList) {
            result.add(Drugs.valueOf(drug));
        }
        return result;
    }

    public static List<Diagnosis> diagnosisListFromArgument(String[] args) {
        List<Diagnosis> result = new ArrayList<>();
        String arg = Utils.firstArgFromInput(args);
        List<String> diagnosisList = Utils.argAsCodesList(arg);
        for (String diagnosis : diagnosisList) {
            result.add(DiagnosisFactory.getDiagnosis(DiagnosisType.valueOf(diagnosis)));
        }
        return result;
    }
}
