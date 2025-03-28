package hospital.simulator.diagnosis;


import hospital.simulator.diagnosis.types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum DiagnosisType {
    F(Fever::new),
    T(Tuberculosis::new),
    H(Healthy::new),
    D(Diabetes::new),
    X(Dead::new);

    private final Supplier<Diagnosis> constructor;

    DiagnosisType(Supplier<Diagnosis> constructor) {
        this.constructor = constructor;
    }
    public Supplier<Diagnosis> getConstructor() {
        return constructor;
    }

    public static List<String> getNames() {
        DiagnosisType[] types = DiagnosisType.values();
        List<String> typesNames = new ArrayList<>();
        for (DiagnosisType dt : types) {
            typesNames.add(dt.name());
        }
        return typesNames;
    }
}
