package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WhatYouLikeToLogScreen {

    private GenericUtility genericUtility;
    private AppiumDriver driver;

    public WhatYouLikeToLogScreen(AppiumDriver driver) {
        this.driver = driver;
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"What would you like to log?\"]")
    private WebElement whatYouLikeToLogHeader;

    @AndroidFindBy(accessibility = "FOOD")
    private WebElement foodLogHeader;

    public void verifyThePresenceOfWhatYouLikeToLogScreen() {
        genericUtility.waitForElementVisible(whatYouLikeToLogHeader, 30);
    }

    public void clickOnFoodLogHeader() {
        genericUtility.click(foodLogHeader);
    }

}
