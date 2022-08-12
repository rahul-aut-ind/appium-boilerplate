package pageObjects;

public class SignupPage extends HelperLibrary{
    public SignupPage(){
        PageFactory.initElements(new AppiumFileDecorator(BaseLibrary.driver),this);
    }
}