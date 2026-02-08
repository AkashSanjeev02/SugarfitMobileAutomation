package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SelectMealScreen {

    private GenericUtility genericUtility;
    private AppiumDriver driver;

    public SelectMealScreen(AppiumDriver driver) {
        this.driver = driver;
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SELECT A MEAL\"]")
    private WebElement selectMealHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pre Breakfast\"]")
    private WebElement preBreakfastOption;

    public void verifyThePresenceOfSelectMealScreen() {
        genericUtility.waitForElementVisible(selectMealHeader, 30);
    }

    public void selectMeal(String mealType) {
        genericUtility.click(preBreakfastOption);
    }
}
