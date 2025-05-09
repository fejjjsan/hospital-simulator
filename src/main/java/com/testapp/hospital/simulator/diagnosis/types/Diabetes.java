package com.testapp.hospital.simulator.diagnosis.types;

import com.testapp.hospital.simulator.healing.Drugs;
import com.testapp.hospital.simulator.diagnosis.CureStrategy;
import com.testapp.hospital.simulator.diagnosis.Diagnosis;
import com.testapp.hospital.simulator.diagnosis.DiagnosisFactory;
import com.testapp.hospital.simulator.diagnosis.DiagnosisType;

import java.util.Set;

public class Diabetes implements Diagnosis, CureStrategy<Drugs> {

    private static final String DIAGNOSIS_CODE = "D";

    @Override
    public Diagnosis cure(Set<Drugs> drugs) {
        if (drugs.contains(Drugs.P) && drugs.contains(Drugs.AS) || !drugs.contains(Drugs.I)) {
            return DiagnosisFactory.getDiagnosis(DiagnosisType.X);
        } else {
            return this;
        }
    }
    @Override
    public String diagnosisCode() {
        return DIAGNOSIS_CODE;
    }

    @Override
    public String toString() {
        return "Diabetes{}";
    }
}
