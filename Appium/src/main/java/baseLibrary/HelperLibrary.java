package baseLibrary;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperLibrary extends BaseLibrary {

    public static final int MAX_POLL_WAIT_TIME_IN_SEC = 5;

    public void enterValue(MobileElement ele, String value) {
        ele.sendKeys(value);
        logger.info("Typed >> " + value);
    }

    public void clickElement(MobileElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_POLL_WAIT_TIME_IN_SEC);
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.click();
        logger.info("Clicked on >> " + ele);
    }

    public String getTextFromElement(MobileElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_POLL_WAIT_TIME_IN_SEC);
        wait.until(ExpectedConditions.visibilityOf(ele));
        logger.info("Getting Text >> " + ele.getText());
        return ele.getText();
    }

    public boolean verifyElementIsDisplayed(MobileElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAX_POLL_WAIT_TIME_IN_SEC);
            logger.info("Checking for visibility of >> " + ele);
            wait.until(ExpectedConditions.visibilityOf(ele));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyElementIsNotDisplayed(MobileElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAX_POLL_WAIT_TIME_IN_SEC);
            logger.info("Checking for visibility of >> " + ele);
            wait.until(ExpectedConditions.invisibilityOf(ele));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateBack() {
        logger.info("Pressing device back button");
        driver.navigate().back();
    }

    public MobileElement androidScrollToElementUsingUiScrollable(String attributeType, String attributeText)
            throws Throwable {
        switch (attributeType.toLowerCase()) {
            case "description":
                return ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\""
                                + attributeText + "\").instance(0))");

            case "resourceid":
                return ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""
                                + attributeText + "\").instance(0))");

            case "classname":
                return ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().className(\""
                                + attributeText + "\").instance(0))");

            case "text":
                return ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                                + attributeText + "\").instance(0))");
            default:
                throw new Exception("Invalid platform Name");
        }
    }

}
