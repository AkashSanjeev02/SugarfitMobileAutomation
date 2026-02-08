package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LogMethodScreen {

    private GenericUtility genericUtility;
    private AppiumDriver driver;

    public LogMethodScreen(AppiumDriver driver) {
        this.driver = driver;
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Select Method\"]")
    private WebElement logMethodHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Log Manually\"]")
    private WebElement logManuallyOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Snap and Log\"]")
    private WebElement snapAndLogOption;


    public void verifyThePresenceOfLogMethodScreen() {
        genericUtility.waitForElementVisible(logMethodHeader, 30);
    }

    public void selectMethod(String method) {
       if (method.equalsIgnoreCase("Log Manually")) {
           genericUtility.click(logManuallyOption);
       } else {
           genericUtility.click(snapAndLogOption);
       }
    }
}
