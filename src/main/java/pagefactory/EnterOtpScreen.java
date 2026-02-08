package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EnterOtpScreen {
    private GenericUtility genericUtility;
    private AppiumDriver driver;

    public EnterOtpScreen(AppiumDriver driver) {
        this.driver = driver;
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter OTP\"]")
    private WebElement enterOtpHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Verify Code\"]")
    private WebElement verifyCodeButton;


    public void verifyThePresenceOfEnterOtpScreen() {
        genericUtility.waitForElementVisible(enterOtpHeader, 30);
    }

    public void enterOTP(String otp) {
        for (int i = 1; i <= 6; i++) {
            String xpath = "(//android.widget.EditText[@content-desc='textInput'])[" + i + "]";
            driver.findElement(By.xpath(xpath)).sendKeys(String.valueOf(otp.charAt(i - 1)));
        }
    }
}