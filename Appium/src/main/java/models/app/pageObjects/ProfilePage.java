package models.app.pageObjects;

import baseLibrary.BaseLibrary;
import baseLibrary.HelperLibrary;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ProfilePage extends HelperLibrary {

    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseLibrary.driver), this);
    }

    String skills[] = {"RxJava", "Docker", "Kotlin"};

    @AndroidFindBy(id = "heading")
    private MobileElement header;

    @AndroidFindBy(id = "logout")
    private MobileElement logout;

    @AndroidFindBy(className = "android.widget.ImageView")
    private MobileElement photo;

    @AndroidFindBy(id = "username")
    private MobileElement username;

    @AndroidFindBy(id = "name")
    private List<MobileElement> skillNames;

    public boolean verifyLoggedInMessage(String msg) throws Throwable {
        return verifyElementIsDisplayed(androidScrollToElementUsingUiScrollable("text", msg));
    }

    public boolean verifySkillsDisplayed() {
        boolean bResult = false;
        for (MobileElement e : skillNames
        ) {
            bResult = Arrays.stream(skills).anyMatch(e.getText()::equals);
        }
        return bResult;
    }

    public boolean verifyUserNameDisplayed() {
        return verifyElementIsDisplayed(username);
    }

    public boolean verifyProfilePage() {
        return getTextFromElement(header).equalsIgnoreCase("PROFILE");
    }

    public boolean verifyProfileImage() {
        return verifyElementIsDisplayed(photo);
    }

    public void clickLogout() {
        clickElement(logout);
    }
}
