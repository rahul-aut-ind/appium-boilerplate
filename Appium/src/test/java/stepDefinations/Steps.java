package stepDefinations;

import baseLibrary.HelperLibrary;
import controllers.POM_Controller;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class Steps extends HelperLibrary {

    POM_Controller pageManger = new POM_Controller();
    protected io.cucumber.java.Scenario scenario;

    @Given("Sample App is installed & launched")
    public void sampleAppIsInstalledLaunched() throws Exception {
        setup_AndroidDriver();
        logger.info("App launched");

    }

    @When("User sees {string} page")
    public void userSeesPage(String pageName) {
        switch (pageName.toUpperCase()) {
            case "LOGIN":
                assertTrue("Login page is not displayed after launch",
                        pageManger.getLoginPage().isLoginScreenDisplayed());
                break;
            case "PROFILE":
                assertTrue("Profile page is not displayed",
                        pageManger.getProfilePage().verifyProfilePage());
                break;
            case "SIGNUP":
                assertTrue("SignUP page is not displayed",
                        pageManger.getSignupPage().verifySignUpPage());
                assertTrue("SignUP page Skills are not displayed",
                        pageManger.getSignupPage().verifySkillsDisplayed());
                break;
        }
        logger.info(pageName + " is displayed. fn-{userSeesPage}");
    }

    @When("User clicks {string} button")
    public void userClicksButton(String btnName) {
        switch (btnName.toUpperCase()) {
            case "SIGNUP":
                pageManger.getLoginPage().clickSignUp();
                break;
            case "LOGOUT":
                pageManger.getProfilePage().clickLogout();
                break;
        }
        logger.info(btnName + " is clicked. fn-{userClicksButton}");
    }

    @And("User tries to login with {string} & {string}")
    public void userTriesToLoginWith(String userName, String password) {
        pageManger.getLoginPage().performLogin(userName, password);
        pageManger.getLoginPage().verifyActionCompleted();
    }


    @Then("User sees {string} message")
    public void userSeesMessage(String arg0) {
        pageManger.getLoginPage().validateInvalidCredsErrorMsg();
    }

    @And("User closes Error popup message")
    public void userClosesErrorPopupMessage() {
        pageManger.getLoginPage().dismissPopup();
    }

    @And("User Signs Up with {string} & {string}")
    public void userSignsUpWith(String userName, String password) {
        pageManger.getSignupPage().createNewUser(userName, password);
    }

    @Then("User is {string}")
    public void userIs(String arg0) {
        assertTrue("Logged In User Profile Pic placeholder not displayed",
                pageManger.getProfilePage().verifyProfileImage());

    }

    @Then("User sees {string} Details")
    public void userSeesDetails(String page) throws Throwable {
        switch (page.toUpperCase()) {
            case "PROFILE":
                assertTrue("Header Mismatch",
                        pageManger.getProfilePage().verifyProfilePage());
                assertTrue("Logged In Message not displayed",
                        pageManger.getProfilePage().verifyLoggedInMessage("Logged In"));
                assertTrue("UserName of Logged In User not displayed",
                        pageManger.getProfilePage().verifyUserNameDisplayed());
                assertTrue("Skills not displayed",
                        pageManger.getProfilePage().verifySkillsDisplayed());
                break;
        }
        logger.info(page + " details validated. fn-{userSeesDetails}");
    }
}
