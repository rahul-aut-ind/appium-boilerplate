package models.app.pageObjects;

import baseLibrary.BaseLibrary;
import baseLibrary.HelperLibrary;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends HelperLibrary {
    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseLibrary.driver), this);
    }

    @AndroidFindBy(id = "textView")
    private MobileElement appNameText;

    @AndroidFindBy(id = "signup")
    private MobileElement signUpBtn;

    @AndroidFindBy(id = "username")
    private MobileElement username;

    @AndroidFindBy(id = "password")
    private MobileElement password;

    @AndroidFindBy(id = "login")
    private MobileElement loginBtn;

    @AndroidFindBy(id = "progress")
    private MobileElement progressAnimation;

    @AndroidFindBy(id = "title")
    private MobileElement popupTitle;

    @AndroidFindBy(id = "description")
    private MobileElement popupMessage;

    @AndroidFindBy(id = "button")
    private MobileElement popupButton;

    public boolean isLoginScreenDisplayed() {
        return (verifyElementIsDisplayed(appNameText)
                && verifyElementIsDisplayed(username)
                && verifyElementIsDisplayed(loginBtn)
        );
    }

    public void clickSignUp() {
        clickElement(signUpBtn);
    }

    public boolean performLogin(String userName, String passkey) {
        enterValue(username, userName);
        enterValue(password, passkey);
        clickElement(loginBtn);
        logger.info("Tried login with {%s} and {%s}", userName,passkey);
        return verifyElementIsDisplayed(progressAnimation);
    }

    public boolean verifyActionCompleted(){
        return verifyElementIsNotDisplayed(progressAnimation);
    }

    public boolean validateInvalidCredsErrorMsg(){
        verifyElementIsNotDisplayed(progressAnimation);
        verifyElementIsDisplayed(popupTitle);
        verifyElementIsDisplayed(popupButton);
        return getTextFromElement(popupMessage).equalsIgnoreCase("Invalid username and / or password");
    }

    public void dismissPopup(){
        clickElement(popupButton);
        verifyElementIsNotDisplayed(popupTitle);
    }

}
