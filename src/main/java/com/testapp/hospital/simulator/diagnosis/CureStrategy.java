package com.testapp.hospital.simulator.diagnosis;

import java.util.Set;

public interface CureStrategy<T> {
    Diagnosis cure(Set<T> drugs);
}
