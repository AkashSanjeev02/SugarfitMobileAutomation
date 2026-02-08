package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeScreen {

    private GenericUtility genericUtility;
    private AppiumDriver driver;

    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(accessibility = "chroniccarehomepage")
    private WebElement homeScreenHeader;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
    private WebElement allowNotificationButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement allowDeviceAccess;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Otp Verification Failed\"]")
    private WebElement verificationFailedMessage;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"LOGGING\"]")
    private WebElement clickOnPlusIconToAddMeal;

    public void verifyThePresenceOfHomeScreen() {
        try {
            genericUtility.waitForElementVisible(allowNotificationButton, 5);
            genericUtility.click(allowNotificationButton);
            System.out.println("Notification Permission Handled.");
        } catch (Exception e) {
            System.out.println("Notification popup did not appear, skipping...");
        }

        try {
            genericUtility.waitForElementVisible(allowDeviceAccess, 5);
            genericUtility.click(allowDeviceAccess);
            System.out.println("Notification Permission Handled.");
        } catch (Exception e) {
            System.out.println("Notification popup did not appear, skipping...");
        }
        genericUtility.waitForElementVisible(homeScreenHeader, 50);
    }

    public void verifyOtpVerificationFailedMessage(String ErrorMessage) {
        genericUtility.waitForElementVisible(verificationFailedMessage, 10);
        Assert.assertEquals(verificationFailedMessage.getText(), ErrorMessage);
    }

    public void clickOnPlusIconToAddMeal() {
        genericUtility.click(clickOnPlusIconToAddMeal);
    }
}
