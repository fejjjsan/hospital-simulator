package hospital.simulator;

import hospital.simulator.utils.Utils;

import java.util.*;

public enum Drugs {
    An, I, As, P;

    public static List<String> getNames() {
        Drugs[] types = Drugs.values();
        List<String> typesNames = new ArrayList<>();
        for (Drugs d : types) {
            typesNames.add(d.name());
        }
        return typesNames;
    }

    public static Set<Drugs> drugsListFromArgument(String[] args) {
        String arg = Utils.secondArgFromInput(args);
        List<String> list = Utils.argAsСodesList(arg);
        Set<Drugs> drugs = new TreeSet<>();
        for (String s: list) {
            drugs.add(Drugs.valueOf(s));
        }
        return drugs;
    }
}
