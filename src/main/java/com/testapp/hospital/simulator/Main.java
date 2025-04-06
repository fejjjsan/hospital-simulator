package com.testapp.hospital.simulator;

import com.testapp.hospital.simulator.chance.OneInAMillionChance;
import com.testapp.hospital.simulator.core.Hospital;
import com.testapp.hospital.simulator.core.HospitalSimulation;
import com.testapp.hospital.simulator.validation.DiagnosesNamesValidator;
import com.testapp.hospital.simulator.validation.DrugNamesValidator;
import com.testapp.hospital.simulator.validation.InputValidator;
import com.testapp.hospital.simulator.validation.RegexInputValidator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var validator = InputValidator.builder()
                .regexInputArgumentsValidator(new RegexInputValidator())
                .diagnosesNamesArgumentsValidator(new DiagnosesNamesValidator())
                .drugNamesArgumentsValidator(new DrugNamesValidator())
                .build();

        if (!validator.validateInput(args)) {
            return;
        }
        var hospital = Hospital.getInstance();
        var chance = new OneInAMillionChance(new Random());
        var hospitalSimulation = HospitalSimulation.builder()
                .hospital(hospital)
                .chance(chance)
                .build();
        hospitalSimulation.beginSimulation(args);
    }
}
