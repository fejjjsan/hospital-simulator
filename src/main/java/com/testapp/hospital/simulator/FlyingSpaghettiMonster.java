package com.testapp.hospital.simulator;


import com.testapp.hospital.simulator.diagnosis.Diagnosis;
import com.testapp.hospital.simulator.diagnosis.DiagnosisFactory;
import com.testapp.hospital.simulator.diagnosis.DiagnosisType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlyingSpaghettiMonster {
    private static final Diagnosis HEALTHY =
            DiagnosisFactory.getDiagnosis(DiagnosisType.valueOf("H"));

    /**
     * Creates FlyingSpaghettiMonster if one-in-a-million chance occurred;
     */
    public static Optional<FlyingSpaghettiMonster> create() {
        if (OneInAMillionChance.chanceOccurred()) {
            return Optional.of(new FlyingSpaghettiMonster());
        }
        return Optional.empty();
    }

    public void doMagic(Patient patient) {
        patient.setDiagnosis(HEALTHY);
    }

}
