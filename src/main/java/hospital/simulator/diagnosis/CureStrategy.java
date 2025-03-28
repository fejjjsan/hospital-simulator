package hospital.simulator.diagnosis;

import hospital.simulator.Drugs;

import java.util.Set;

public interface CureStrategy<T> {
    Diagnosis cure(Set<T> drugs);
}
