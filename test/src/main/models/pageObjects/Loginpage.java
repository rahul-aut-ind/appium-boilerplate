package pageObjects;

public class Loginpage extends HelperLibrary{
    public Loginpage(){
        PageFactory.initElements(new AppiumFileDecorator(BaseLibrary.driver),this);
    }
}