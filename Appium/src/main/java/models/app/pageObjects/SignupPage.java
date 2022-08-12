package models.app.pageObjects;

import baseLibrary.BaseLibrary;
import baseLibrary.HelperLibrary;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends HelperLibrary {
    public SignupPage(){
        PageFactory.initElements(new AppiumFieldDecorator(BaseLibrary.driver),this);
    }

    @AndroidFindBy(id = "header_toolbar_title")
    private MobileElement billingScreenHeader;
}
