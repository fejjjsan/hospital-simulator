package hospital.simulator;

import hospital.simulator.validation.DiagnosesNamesValidator;
import hospital.simulator.validation.DrugNamesValidator;
import hospital.simulator.validation.InputValidator;
import hospital.simulator.validation.RegexInputValidator;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info("App start");

        if (args.length == 0) {
            logger.info("No input provided");
            logger.info("App exit");
            return;
        }

        var validator = InputValidator.builder()
                .regexInputValidator(new RegexInputValidator())
                .diagnosesNamesValidator(new DiagnosesNamesValidator())
                .drugNamesValidator(new DrugNamesValidator())
                .build();

        if (!validator.validateInput(args)) {
            logger.info("Incorrect input");
            logger.info("App exit");
            return;
        };

        var hospital = Hospital.getInstance();
        hospital.addPatients(args);

        if (args.length > 1) {
            hospital.administerDrugs(Drugs.drugsListFromArgument(args));
        }
        hospital.getTreatmentResults();

        logger.info("App exit");
    }

}
