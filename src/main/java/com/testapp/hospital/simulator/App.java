package com.testapp.hospital.simulator;

import com.testapp.hospital.simulator.utils.ArgumentsParser;
import com.testapp.hospital.simulator.utils.PrintUtils;
import com.testapp.hospital.simulator.utils.Utils;
import com.testapp.hospital.simulator.validation.DrugNamesValidator;
import com.testapp.hospital.simulator.validation.DiagnosesNamesValidator;
import com.testapp.hospital.simulator.validation.InputValidator;
import com.testapp.hospital.simulator.validation.RegexInputValidator;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class App {

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
        hospital.addPatients(ArgumentsParser.diagnosisListFromArgument(args));
        hospital.administerDrugs(ArgumentsParser.drugsListFromArgument(args));


        Optional<FlyingSpaghettiMonster> monster = FlyingSpaghettiMonster.create();
        log.debug("MONSTER IS HERE: {}", monster.isPresent());
        Optional<Patient> deadPatient = hospital.getFirstDeadPatient();
        log.debug("DEAD PATIENT IS PRESENT: {}", deadPatient.isPresent());


        if (monster.isPresent() && deadPatient.isPresent()) {
            Patient patient = deadPatient.get();
            monster.get().doMagic(patient);
            log.debug("DEAD PATIENT IS HEALTHY: {}", patient.getDiagnosis());
        }

        var treatmentResults = hospital.getTreatmentResults();
        var formatResult = Utils.formatResult(treatmentResults);
        PrintUtils.printResultOfTreatment(formatResult);

    }

}
