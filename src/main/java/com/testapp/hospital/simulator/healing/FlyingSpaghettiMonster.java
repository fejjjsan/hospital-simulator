package com.testapp.hospital.simulator.healing;

import com.testapp.hospital.simulator.core.Patient;
import com.testapp.hospital.simulator.chance.ChanceEvaluater;
import com.testapp.hospital.simulator.diagnosis.Diagnosis;
import com.testapp.hospital.simulator.diagnosis.DiagnosisFactory;
import com.testapp.hospital.simulator.diagnosis.DiagnosisType;

import java.util.Optional;

public class FlyingSpaghettiMonster {
    private static final Diagnosis HEALTHY =
            DiagnosisFactory.getDiagnosis(DiagnosisType.valueOf("H"));

    /**
     * Creates FlyingSpaghettiMonster if chanceEvaluater returns true;
     */
    public static Optional<FlyingSpaghettiMonster> create(ChanceEvaluater chanceEvaluater) {
        if (chanceEvaluater.isChanceOccurred()) {
            return Optional.of(new FlyingSpaghettiMonster());
        }
        return Optional.empty();
    }

    public void doMagic(Patient patient) {
        patient.setDiagnosis(HEALTHY);
    }

}
