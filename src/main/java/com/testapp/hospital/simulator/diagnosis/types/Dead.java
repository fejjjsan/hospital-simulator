package com.testapp.hospital.simulator.diagnosis.types;

import com.testapp.hospital.simulator.healing.Drugs;
import com.testapp.hospital.simulator.diagnosis.CureStrategy;
import com.testapp.hospital.simulator.diagnosis.Diagnosis;

import java.util.Set;

public class Dead implements Diagnosis, CureStrategy<Drugs> {

    private static final String DIAGNOSIS_CODE = "X";

    @Override
    public Diagnosis cure(Set<Drugs> drugs) {
        return this;
    }

    @Override
    public String diagnosisCode() {
        return DIAGNOSIS_CODE;
    }

    @Override
    public String toString() {
        return "Dead{}";
    }
}
