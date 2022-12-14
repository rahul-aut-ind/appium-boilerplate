package models.app.pageObjects;

import baseLibrary.BaseLibrary;
import baseLibrary.HelperLibrary;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class SignupPage extends HelperLibrary {
    public SignupPage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseLibrary.driver), this);
    }

    String skills[] = {"RxJava", "Docker", "Kotlin"};

    @AndroidFindBy(id = "heading")
    private MobileElement header;

    @AndroidFindBy(id = "username")
    private MobileElement username;

    @AndroidFindBy(id = "password")
    private MobileElement password;

    @AndroidFindBy(id = "password2")
    private MobileElement confirmPassword;

    @AndroidFindBy(id = "signup")
    private MobileElement signup;

    @AndroidFindBy(id = "progress")
    private MobileElement progressAnimation;

    @AndroidFindBy(id = "name")
    private List<MobileElement> skillNames;

    public boolean verifySkillsDisplayed() {
        boolean bResult = false;
        for (MobileElement e : skillNames
        ) {
            bResult = Arrays.stream(skills).anyMatch(e.getText()::equals);
        }
        return bResult;
    }

    public boolean verifySignUpPage() {
        return getTextFromElement(header).equalsIgnoreCase("SIGN UP");
    }

    public boolean createNewUser(String userName, String passkey) {
        enterValue(username, userName);
        enterValue(password, passkey);
        enterValue(confirmPassword, passkey);
        clickElement(signup);
        return verifyElementIsDisplayed(progressAnimation);
    }
}
