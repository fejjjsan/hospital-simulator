package hospital.simulator.diagnosis.types;

import hospital.simulator.Drugs;
import hospital.simulator.diagnosis.CureStrategy;
import hospital.simulator.diagnosis.Diagnosis;
import hospital.simulator.diagnosis.DiagnosisFactory;
import hospital.simulator.diagnosis.DiagnosisType;

import java.util.Set;

public class Tuberculosis implements Diagnosis, CureStrategy<Drugs> {
    private static final String CODE = "T";

    @Override
    public Diagnosis cure(Set<Drugs> drugs) {
        if (drugs.contains(Drugs.P) && drugs.contains(Drugs.As)) {
            return DiagnosisFactory.getDiagnosis(DiagnosisType.X);
        } else if (drugs.contains(Drugs.An) && drugs.contains(Drugs.I)) {
            return DiagnosisFactory.getDiagnosis(DiagnosisType.F);
        } else if (drugs.contains(Drugs.An)) {
            return DiagnosisFactory.getDiagnosis(DiagnosisType.H);
        } else {
            return this;
        }
    }

    @Override
    public String diagnosisCode() {
        return CODE;
    }

    @Override
    public String toString() {
        return "Tuberculosis{}";
    }
}
