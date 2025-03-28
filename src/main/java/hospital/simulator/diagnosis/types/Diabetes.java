package hospital.simulator.diagnosis.types;

import hospital.simulator.Drugs;
import hospital.simulator.diagnosis.CureStrategy;
import hospital.simulator.diagnosis.Diagnosis;
import hospital.simulator.diagnosis.DiagnosisFactory;
import hospital.simulator.diagnosis.DiagnosisType;

import java.util.Set;

public class Diabetes implements Diagnosis, CureStrategy<Drugs> {

    private static final String CODE = "D";

    @Override
    public Diagnosis cure(Set<Drugs> drugs) {
        if (drugs.contains(Drugs.P) && drugs.contains(Drugs.As)) {
            return DiagnosisFactory.getDiagnosis(DiagnosisType.X);
        } else if (drugs.contains(Drugs.I)) {
            return this;
        } else {
            return DiagnosisFactory.getDiagnosis(DiagnosisType.X);
        }
    }
    @Override
    public String diagnosisCode() {
        return CODE;
    }

    @Override
    public String toString() {
        return "Diabetes{}";
    }
}
