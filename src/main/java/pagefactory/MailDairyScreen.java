package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MailDairyScreen {

    private GenericUtility genericUtility;
    private AppiumDriver driver;

    public MailDairyScreen(AppiumDriver driver) {
        this.driver = driver;
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"View Meal Diary\"]/android.view.ViewGroup")
    private WebElement mailDairyHeader;

    public void verifyThePresenceOfMailDairyScreen() {
        genericUtility.waitForElementVisible(mailDairyHeader, 30);
    }
}
