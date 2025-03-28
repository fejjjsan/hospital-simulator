package hospital.simulator.diagnosis.types;

import hospital.simulator.Drugs;
import hospital.simulator.diagnosis.CureStrategy;
import hospital.simulator.diagnosis.Diagnosis;

import java.util.Set;

public class Dead implements Diagnosis, CureStrategy<Drugs> {

    private static final String CODE = "X";

    @Override
    public Diagnosis cure(Set<Drugs> drugs) {
        return this;
    }

    @Override
    public String diagnosisCode() {
        return CODE;
    }

    @Override
    public String toString() {
        return "Dead{}";
    }
}
