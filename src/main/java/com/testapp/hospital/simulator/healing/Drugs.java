package com.testapp.hospital.simulator.healing;

import java.util.ArrayList;
import java.util.List;

public enum Drugs {
    AN,
    I,
    AS,
    P;

    public static List<String> getNames() {
        Drugs[] types = Drugs.values();
        List<String> typesNames = new ArrayList<>();
        for (Drugs drugType : types) {
            typesNames.add(drugType.name());
        }
        return typesNames;
    }

}
