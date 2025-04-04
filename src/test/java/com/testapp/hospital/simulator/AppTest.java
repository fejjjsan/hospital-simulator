package com.testapp.hospital.simulator;


import com.testapp.hospital.simulator.random.integer.RandomInteger;
import com.testapp.hospital.simulator.validation.DiagnosesNamesValidator;
import com.testapp.hospital.simulator.validation.DrugNamesValidator;
import com.testapp.hospital.simulator.validation.InputValidator;
import com.testapp.hospital.simulator.validation.RegexInputValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AppTest {
    private Hospital hospital;
    private HospitalSimulation hospitalSimulation;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static InputValidator validator;
    private static ChanceEvaluater chanceEvaluatesToTrue;
    private static ChanceEvaluater chanceEvaluatesToFalse;
    private static RandomInteger monsterAlwaysShowsUp;
    private static RandomInteger monsterNeverShowsUp;

    @BeforeAll
    public static void initVariables() {
        validator = InputValidator.builder()
                .regexInputArgumentsValidator(new RegexInputValidator())
                .diagnosesNamesArgumentsValidator(new DiagnosesNamesValidator())
                .drugNamesArgumentsValidator(new DrugNamesValidator())
                .build();

        monsterAlwaysShowsUp = () -> 10; // SUCCESS_VALUE in OneInAMillionChance.java
        monsterNeverShowsUp = () -> 1;
        chanceEvaluatesToTrue = new OneInAMillionChance(monsterAlwaysShowsUp);
        chanceEvaluatesToFalse = new OneInAMillionChance(monsterNeverShowsUp);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        hospital = Hospital.getInstance();
        hospitalSimulation = HospitalSimulation.builder()
                .hospital(hospital)
                .validator(validator)
                .chance(chanceEvaluatesToFalse)
                .build();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void Patient_with_diabetes_dies_without_insulin() {
        var args = new String[]{"D"};
        hospitalSimulation.beginSimulation(args);
        assertThat("F:0,H:0,D:0,T:0,X:1").isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    void Patient_with_diabetes_avoids_dying_if_takes_insulin() {
        var args = new String[]{"D", "I"};
        hospitalSimulation.beginSimulation(args);
        assertThat("F:0,H:0,D:1,T:0,X:0").isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    void Patient_with_fever_gets_healthy_if_takes_paracetamol() {
        var args = new String[]{"F", "P"};
        hospitalSimulation.beginSimulation(args);
        assertThat("F:0,H:1,D:0,T:0,X:0").isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    void Patient_with_fever_gets_healthy_if_takes_aspirin() {
        var args = new String[]{"F", "As"};
        hospitalSimulation.beginSimulation(args);
        assertThat("F:0,H:1,D:0,T:0,X:0").isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    void Patient_how_is_healthy_catch_fever_if_antibiotic_mixed_with_insulin() {
        var args = new String[]{"H,F", "An,I"};
        hospitalSimulation.beginSimulation(args);
        assertThat("F:2,H:0,D:0,T:0,X:0").isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    void Patient_dies_if_paracetamol_mixed_with_aspirin() {
        var args = new String[]{"H,F,T,D", "As,P"};
        hospitalSimulation.beginSimulation(args);
        assertThat("F:0,H:0,D:0,T:0,X:4").isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    void Flying_monster_resurrects_a_dead_patient_if_monster_shows_uo() {
        var hospital = Hospital.getInstance();
        var hospitalSimulation = HospitalSimulation.builder()
                .hospital(hospital)
                .validator(validator)
                .chance(chanceEvaluatesToTrue)
                .build();
        var args = new String[]{"X"};
        hospitalSimulation.beginSimulation(args);
        assertThat("F:0,H:1,D:0,T:0,X:0").isEqualTo(outputStreamCaptor.toString().trim());
    }


}
