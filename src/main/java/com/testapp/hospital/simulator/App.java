package com.testapp.hospital.simulator;

import com.testapp.hospital.simulator.random.integer.RandomIntegerFromOneToMillion;
import com.testapp.hospital.simulator.validation.DiagnosesNamesValidator;
import com.testapp.hospital.simulator.validation.DrugNamesValidator;
import com.testapp.hospital.simulator.validation.InputValidator;
import com.testapp.hospital.simulator.validation.RegexInputValidator;

public class App {
    public static void main(String[] args) {
        var validator = InputValidator.builder()
                .regexInputArgumentsValidator(new RegexInputValidator())
                .diagnosesNamesArgumentsValidator(new DiagnosesNamesValidator())
                .drugNamesArgumentsValidator(new DrugNamesValidator())
                .build();
        var chance = new OneInAMillionChance(new RandomIntegerFromOneToMillion());
        var hospitalSimulation = HospitalSimulation.builder()
                .validator(validator)
                .chance(chance)
                .build();
        hospitalSimulation.beginSimulation(args);
    }
}
