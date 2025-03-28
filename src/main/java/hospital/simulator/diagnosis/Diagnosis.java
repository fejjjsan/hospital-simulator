package hospital.simulator.diagnosis;

import hospital.simulator.Drugs;

import java.util.Set;

public interface Diagnosis {
    String diagnosisCode();

    Diagnosis cure(Set<Drugs> drugs);
}
