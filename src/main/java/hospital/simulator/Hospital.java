package hospital.simulator;

import hospital.simulator.diagnosis.CureStrategy;
import hospital.simulator.diagnosis.Diagnosis;
import hospital.simulator.diagnosis.DiagnosisFactory;
import hospital.simulator.diagnosis.DiagnosisType;
import hospital.simulator.utils.Utils;
import jdk.jshell.execution.Util;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
public class Hospital {
    private static final Hospital INSTANCE = new Hospital();
    private final ArrayList<Patient> patients = new ArrayList<>();
    public static Hospital getInstance() {
        return INSTANCE;
    }
    public ArrayList<Patient> getPatients() {
        return patients;
    }
    private void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void administerDrugs(Set<Drugs> drugs) {
        for (Patient p: patients) {
            var diagnosis = (CureStrategy<?>) p.getDiagnosis().cure(drugs);
            p.setDiagnosis((Diagnosis) diagnosis);
        }
    }

    public void addPatients(String[] args) {
        String arg = Utils.firstArgFromInput(args);
        List<String> list = Utils.argAsСodesList(arg);
        for (String s: list) {
            addPatient(Patient.newInstance(
                    DiagnosisFactory.getDiagnosis(
                            DiagnosisType.valueOf(s))));
        }
    }
    public void getTreatmentResults() {
        List<String> newDiagnosis = new ArrayList<>();
        for (Patient p: patients) {
            newDiagnosis.add(p.getDiagnosis().diagnosisCode());
        }
        Utils.formatResult(newDiagnosis);
    }
}
