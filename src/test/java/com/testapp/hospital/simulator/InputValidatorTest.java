package com.testapp.hospital.simulator;

import com.testapp.hospital.simulator.validation.DiagnosesNamesValidator;
import com.testapp.hospital.simulator.validation.DrugNamesValidator;
import com.testapp.hospital.simulator.validation.InputValidator;
import com.testapp.hospital.simulator.validation.RegexInputValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTest {

    private static String[] extraSpaceAfterComma;
    private static String[] commaAtTheEndOfSecondArg;
    private static String[] extraSpaceAtTheEndOfSecondArg;
    private static String[] extraCommaBetweenArgs;
    private static String[] invalidDiagnosisCode;
    private static String[] commaAfterTheFirstArg;
    private static String[] validDiagnosisCodes;
    private static String[] invalidDrugCode;
    private static String[] validDrugsCodes;
    private static InputValidator validator;


    @BeforeAll
    static void beforeAll() {
        extraSpaceAfterComma = new String[]{"D, T"};
        commaAtTheEndOfSecondArg = new String[]{"D", " As,"};
        extraSpaceAtTheEndOfSecondArg = new String[]{"D,F", " As "};
        extraCommaBetweenArgs = new String[]{"D,F,,T"};
        commaAfterTheFirstArg = new String[]{"D,"};

        invalidDiagnosisCode = new String[]{"F,W"};
        // All valid drug codes
        validDiagnosisCodes = new String[]{"D,X,T,F,H"};
        // For drugs to be validated, diagnosis should be present as the first argument.
        invalidDrugCode = new String[]{"D,X,T,F,H", "As,R"};
        validDrugsCodes = new String[]{"D,X,T,F,H", "As,I,An,P"};


        validator = InputValidator.builder()
                .regexInputArgumentsValidator(new RegexInputValidator())
                .diagnosesNamesArgumentsValidator(new DiagnosesNamesValidator())
                .drugNamesArgumentsValidator(new DrugNamesValidator())
                .build();
    }

    @Test
    void Arg_with_extra_space_after_comma_failing_validation() {
        assertFalse(validator.validateInput(extraSpaceAfterComma));
    }

    @Test
    void Arg_with_comma_at_the_end_of_the_second_arg_failing_validation() {
        assertFalse(validator.validateInput(commaAtTheEndOfSecondArg));
    }

    @Test
    void Arg_with_extra_space_at_the_end_of_the_second_arg_failing_validation() {
        assertFalse(validator.validateInput(extraSpaceAtTheEndOfSecondArg));
    }

    @Test
    void Arg_with_extra_comma_between_args_failing_validation() {
        assertFalse(validator.validateInput(extraCommaBetweenArgs));
    }

    @Test
    void Arg_with_comma_after_the_first_arg_failing_validation() {
        assertFalse(validator.validateInput(commaAfterTheFirstArg));
    }

    @Test
    void Arg_with_invalid_diagnosis_code_failing_validation() {
        assertFalse(validator.validateInput(invalidDiagnosisCode));
    }

    @Test
    void Arg_with_invalid_drug_code_failing_validation() {
        assertFalse(validator.validateInput(invalidDrugCode));
    }

    @Test
    void Arg_with_valid_diagnosis_codes_succeed_validation() {
        assertTrue(validator.validateInput(validDiagnosisCodes));
    }

    @Test
    void Arg_with_valid_drug_codes_succeed_validation() {
        assertTrue(validator.validateInput(validDrugsCodes));
    }

}
