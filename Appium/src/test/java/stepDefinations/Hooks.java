package stepDefinations;

import baseLibrary.HelperLibrary;
import io.cucumber.java.*;


public class Hooks extends HelperLibrary {

    @Before
    public void startScenario(Scenario scenario) throws Exception {
        logger.info("*** Starting Scenario - %s ***", scenario.getName());
    }

    @After
    public void endScenario(Scenario scenario) {
        logger.info("*** Closing driver. Scenario End - %s ***", scenario.getName());
        closeDriver();
    }
}