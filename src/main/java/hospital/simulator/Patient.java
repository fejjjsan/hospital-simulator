package hospital.simulator;

import hospital.simulator.diagnosis.Diagnosis;
public class Patient {
    private Diagnosis diagnosis;

    private Patient(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public static Patient newInstance(Diagnosis d) {
        return new Patient(d);
    }

    public Diagnosis getDiagnosis() {
        return  diagnosis;
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
