package com.testapp.hospital.simulator.core;

import com.testapp.hospital.simulator.chance.ChanceEvaluater;
import com.testapp.hospital.simulator.healing.FlyingSpaghettiMonster;
import com.testapp.hospital.simulator.utils.ArgumentsParser;
import com.testapp.hospital.simulator.utils.PrintUtils;
import com.testapp.hospital.simulator.utils.Utils;

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
    private final ChanceEvaluater chance;

    public void beginSimulation(String[] args) {

        hospital.addPatients(ArgumentsParser.diagnosisListFromArgument(args));
        hospital.administerDrugs(ArgumentsParser.drugsListFromArgument(args));

        Optional<FlyingSpaghettiMonster> monster = FlyingSpaghettiMonster.create(chance);
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
