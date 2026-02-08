package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginScreen extends BaseClass {

    private GenericUtility genericUtility;
    private AppiumDriver driver;

    public LoginScreen(AppiumDriver driver) {
        this.driver = driver;
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"PHONE_NUMBER0_INPUT\"]")
    private WebElement phoneNumberField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Verification Code']")
    private WebElement sendVerificationCodeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"OR LOGIN WITH\"]")
    private WebElement orLoginWithLabel;

    public void verifyThePresenceOfLoginScreen() {
        Assert.assertTrue(genericUtility.isElementVisible(phoneNumberField));
    }

    public void enterPhoneNumber(String phoneNumber) {
        genericUtility.click(phoneNumberField);
        genericUtility.type(phoneNumberField, phoneNumber);
        genericUtility.hideKeyboard();

    }

    public void clickSendVerificationCodeButton() {
        genericUtility.click(sendVerificationCodeButton);
    }
}
