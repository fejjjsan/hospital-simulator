package com.testapp.hospital.simulator.diagnosis;

import com.testapp.hospital.simulator.healing.Drugs;

import java.util.Set;

public interface Diagnosis {
    String diagnosisCode();

    Diagnosis cure(Set<Drugs> drugs);
}
