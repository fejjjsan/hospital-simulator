package com.testapp.hospital.simulator.diagnosis.types;

import com.testapp.hospital.simulator.healing.Drugs;
import com.testapp.hospital.simulator.diagnosis.CureStrategy;
import com.testapp.hospital.simulator.diagnosis.Diagnosis;
import com.testapp.hospital.simulator.diagnosis.DiagnosisFactory;
import com.testapp.hospital.simulator.diagnosis.DiagnosisType;

import java.util.Set;

public class Fever implements Diagnosis, CureStrategy<Drugs> {
    private static final String DIAGNOSIS_CODE = "F";

    @Override
    public Diagnosis cure(Set<Drugs> drugs) {
        if (drugs.contains(Drugs.P) && drugs.contains(Drugs.AS)) {
            return DiagnosisFactory.getDiagnosis(DiagnosisType.X);
        } else if (drugs.contains(Drugs.P) || drugs.contains(Drugs.AS)) {
            return DiagnosisFactory.getDiagnosis(DiagnosisType.H);
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
        return "Fever{}";
    }
}
