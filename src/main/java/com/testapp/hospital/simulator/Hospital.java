package com.testapp.hospital.simulator;

import com.testapp.hospital.simulator.diagnosis.CureStrategy;
import com.testapp.hospital.simulator.diagnosis.Diagnosis;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import lombok.Getter;

@Getter
public class Hospital {


    private final ArrayList<Patient> patients;

    public static Hospital getInstance() {
        return new Hospital();
    }
    private Hospital() {
        this.patients = new ArrayList<>();
    }

    private void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addPatients(List<Diagnosis> diagnoses) {
        for (Diagnosis d: diagnoses) {
            addPatient(Patient.newInstance(d));
        }
    }

    public void administerDrugs(Set<Drugs> drugs) {
        for (Patient p: patients) {
            var diagnosis = (CureStrategy<?>) p.getDiagnosis().cure(drugs);
            p.setDiagnosis((Diagnosis) diagnosis);
        }
    }

    public List<String> getTreatmentResults() {
        List<String> newDiagnosis = new ArrayList<>();
        for (Patient p: patients) {
            var diagnosisCode = p.getDiagnosis().diagnosisCode();
            newDiagnosis.add(diagnosisCode);
        }
        return newDiagnosis;
    }

    public Optional<Patient> getFirstDeadPatient() {
        String dead = "X";
        return patients.stream().filter(p -> p.getDiagnosis().diagnosisCode().equals(dead))
                .findFirst();
    }
}
