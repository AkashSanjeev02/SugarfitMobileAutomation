package Utility;

import java.time.Duration;

import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GenericUtility {

    private AppiumDriver driver;
    private WebDriverWait wait;

    // ================= CONSTRUCTOR =================
    public GenericUtility(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ================= PAGE INITIALIZATION =================
    /**
     * Initializes @AndroidFindBy / @iOSXCUITFindBy elements
     * Must be called once in every Page Object constructor
     */
    public void initPageElements(Object page) {
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(20)),
                page
        );
    }

    // ================= WAIT METHODS =================

    private WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait =
                new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return customWait.until(ExpectedConditions.visibilityOf(element));
    }

    // ================= ACTION METHODS =================
    public void click(WebElement element) {
        // Explicitly wait for both states to be sure
        waitForVisible(element);
        element.click();
    }

    public void type(WebElement element, String text) {
        WebElement el = waitForVisible(element);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void hideKeyboard() {
        try {
            // Cast the driver instance to the HidesKeyboard interface (implemented by AndroidDriver)
            ((HidesKeyboard) driver).hideKeyboard();
            System.out.println("Keyboard hidden using cast.");
        } catch (Exception e) {
            System.out.println("Could not hide keyboard: " + e.getMessage());
        }
    }

}