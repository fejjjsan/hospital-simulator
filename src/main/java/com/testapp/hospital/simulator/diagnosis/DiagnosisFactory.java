package com.testapp.hospital.simulator.diagnosis;

public class DiagnosisFactory {
    public static Diagnosis getDiagnosis(DiagnosisType type) {
        return type.getConstructor().get();
    }
}
