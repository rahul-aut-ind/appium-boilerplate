package stepDefinations;

import io.cucumber.java.*;
import main.baseLibrary.HelperLibrary;

public class Hooks extends HelperLibrary{

    @Before
    public void startScenario(Scenario scenario) throws Exception{
        logger.info("*** Starting Scenario - %s ***",scenario.getName());
        setup_AndroidDriver();
    }

    @After
    public void endScenario(Scenario scenario){
        logger.info("*** Closing driver. Scenario End - %s ***",scenario.getName());
        closeDriver();
    }
}