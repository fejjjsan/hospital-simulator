package com.testapp.hospital.simulator.core;

import com.testapp.hospital.simulator.diagnosis.Diagnosis;
import lombok.Getter;

@Getter
public class Patient {
    private Diagnosis diagnosis;

    private Patient(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public static Patient newInstance(Diagnosis d) {
        return new Patient(d);
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "diagnosis=" + diagnosis +
                '}';
    }
}
