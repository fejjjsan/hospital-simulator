package com.testapp.hospital.simulator;

import com.testapp.hospital.simulator.utils.ArgumentsParser;
import com.testapp.hospital.simulator.utils.PrintUtils;
import com.testapp.hospital.simulator.utils.Utils;
import com.testapp.hospital.simulator.validation.InputValidator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Builder
@Getter
@Setter
public class HospitalSimulation {

    private final Hospital hospital;
    private final InputValidator validator;
    private final ChanceEvaluater chance;

    public void beginSimulation(String[] args) {

        if (!validator.validateInput(args)) {
            return;
        }

        hospital.addPatients(ArgumentsParser.diagnosisListFromArgument(args));
        hospital.administerDrugs(ArgumentsParser.drugsListFromArgument(args));

        Optional<FlyingSpaghettiMonster> monster = isMonsterHere();
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

    public Optional<FlyingSpaghettiMonster> isMonsterHere() {
        return FlyingSpaghettiMonster.create(chance);
    }
}
