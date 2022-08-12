package controllers;

import models.app.pageObjects.*;

public class POM_Controller {
    private LoginPage loginPage;
    private SignupPage signupPage;

    public POM_Controller(){

    }

    public LoginPage getLoginPage() {
        return (
                loginPage==null ? new LoginPage(): loginPage
        );
    }

    public SignupPage getSignupPage() {
        return (
                signupPage==null ? new SignupPage(): signupPage
        );
    }
}
