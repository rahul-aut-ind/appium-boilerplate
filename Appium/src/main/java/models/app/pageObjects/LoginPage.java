package models.app.pageObjects;

import baseLibrary.BaseLibrary;
import baseLibrary.HelperLibrary;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends HelperLibrary {
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(BaseLibrary.driver),this);
    }

    @AndroidFindBy(id = "header_toolbar_title")
    private MobileElement billingScreenHeader;
}
