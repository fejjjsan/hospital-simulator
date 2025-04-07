package com.testapp.hospital.simulator;


import com.testapp.hospital.simulator.chance.ChanceEvaluater;
import com.testapp.hospital.simulator.chance.OneInAMillionChance;
import com.testapp.hospital.simulator.core.Hospital;
import com.testapp.hospital.simulator.core.HospitalSimulation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ComponentTest {
    private Hospital hospital;
    private HospitalSimulation hospitalSimulation;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static ChanceEvaluater chanceEvaluatesToTrue;
    private static ChanceEvaluater chanceEvaluatesToFalse;

    /**
     * With this seed OneInAMillionChance.isChanceOccurred() always evaluates to true
     */
    private static final int SUCCESS_SEED = 377805;

    /**
     * With this seed OneInAMillionChance.isChanceOccurred() always evaluates to false
     */
    private static final int FALSE_SEED = 1;


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        hospital = Hospital.getInstance();
        Random monsterAlwaysShowsUp = new Random(SUCCESS_SEED);
        Random monsterNeverShowsUp = new Random(FALSE_SEED);
        chanceEvaluatesToTrue = new OneInAMillionChance(monsterAlwaysShowsUp);
        chanceEvaluatesToFalse = new OneInAMillionChance(monsterNeverShowsUp);
        hospitalSimulation = HospitalSimulation.builder()
                .hospital(hospital)
                .chance(chanceEvaluatesToFalse)
                .build();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void Patient_with_diabetes_dies_without_insulin() {
        var args = new String[]{"D,X"};
        hospitalSimulation.beginSimulation(args);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("F:0,H:0,D:0,T:0,X:2");
    }

    @Test
    void Patient_with_diabetes_avoids_dying_if_takes_insulin() {
        var args = new String[]{"D,X", "I"};
        hospitalSimulation.beginSimulation(args);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("F:0,H:0,D:1,T:0,X:1");
    }

    @Test
    void Patient_with_fever_gets_healthy_if_takes_paracetamol() {
        var args = new String[]{"F,X", "P"};
        hospitalSimulation.beginSimulation(args);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("F:0,H:1,D:0,T:0,X:1");
    }

    @Test
    void Patient_with_fever_gets_healthy_if_takes_aspirin() {
        var args = new String[]{"F,X", "As"};
        hospitalSimulation.beginSimulation(args);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("F:0,H:1,D:0,T:0,X:1");
    }

    @Test
    void Patient_how_is_healthy_catch_fever_if_antibiotic_mixed_with_insulin() {
        var args = new String[]{"H,F,X", "An,I"};
        hospitalSimulation.beginSimulation(args);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("F:2,H:0,D:0,T:0,X:1");
    }

    @Test
    void Patient_dies_if_paracetamol_mixed_with_aspirin() {
        var args = new String[]{"H,F,T,D", "As,P"};
        hospitalSimulation.beginSimulation(args);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("F:0,H:0,D:0,T:0,X:4");
    }

    @Test
    void Flying_monster_resurrects_a_dead_patient_if_monster_shows_up() {
        var hospital = Hospital.getInstance();
        var hospitalSimulation = HospitalSimulation.builder()
                .hospital(hospital)
                .chance(chanceEvaluatesToTrue)
                .build();
        var args = new String[]{"X"};
        hospitalSimulation.beginSimulation(args);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("F:0,H:1,D:0,T:0,X:0");
    }


}
