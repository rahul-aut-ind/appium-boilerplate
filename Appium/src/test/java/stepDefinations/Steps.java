package stepDefinations;

import baseLibrary.HelperLibrary;
import controllers.POM_Controller;
import io.cucumber.java.en.Given;

public class Steps extends HelperLibrary {

    POM_Controller pageManger = new POM_Controller();
    protected io.cucumber.java.Scenario scenario;

    @Given("Sample App is installed & launched")
    public void sampleAppIsInstalledLaunched() throws Exception {
        setup_AndroidDriver();
        logger.info("App launched");
    }
}
