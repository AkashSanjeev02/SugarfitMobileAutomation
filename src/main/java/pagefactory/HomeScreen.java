package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen {
    private GenericUtility genericUtility;

    public HomeScreen(AppiumDriver driver) {
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(accessibility = "chroniccarehomepage")
    private WebElement homeScreenHeader;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
    private WebElement allowNotificationButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement allowDeviceAccess;

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
}
