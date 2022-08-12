package baseLibrary;

import io.appium.java_client.appmanagement.ApplicationState;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class BaseLibrary {
    public static AndroidDriver driver;
    public static URL appiumURL;
    public static final Logger logger= LoggerFactory.getLogger(BaseLibrary.class);
    public static DesiredCapabilities caps= null;
    public static String sBundleId= null;
    public static String sAppActivity= null;
    public static String sAndroidDevice= null;
    public static SessionId session = null;


    static {
        sBundleId = System.getProperty("bundleID");
        sAppActivity= System.getProperty("activityName");
        sAndroidDevice= System.getProperty("deviceID");

        try{
            appiumURL = new URL("http://127.0.0.1:4723/wd/hd");
        }catch(MalformedURLException e){}
    }

    public static void setup_AndroidDriver() throws Exception{

        caps = new DesiredCapabilities();

        caps.setCapability("udid",sAndroidDevice);
        caps.setCapability("platformName","Android");
        caps.setCapability("appPackage",sBundleId);
        //caps.setCapability("appActivity",sAppActivity);

        caps.setCapability("automationName","UiAutomator2");

        logger.info(caps.toString());

        driver= new AndroidDriver<AndroidElement>(appiumURL, caps);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        session = ((AndroidDriver<AndroidElement>)driver).getSessionId();

        logger.info("New Session established with id : "+ session.toString());

        ApplicationState state = driver.queryAppState(sBundleId);

        if(state == ApplicationState.NOT_INSTALLED || state == ApplicationState.NOT_RUNNING){
            String msg = "App could not be installed or launched";
            logger.error(msg);
            throw new Exception(msg);
        }

    }

    public static void closeDriver(){
        driver.quit();
    }

}
