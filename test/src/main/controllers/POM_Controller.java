package controllers;

import models.pageObejcts.*;

public class POM_Controller{

    private LoginPage loginPage;
    private SignupPage signupPage;

    public POM_Controller(){

    }

    public LoginPage getLoginPage() {
        return (
            loginPage==null ? new loginPage(): loginPage
        );
    }

    public SignupPage getSignupPage() {
        return (
            signupPage==null ? new signupPage(): signupPage
        );
    }
}