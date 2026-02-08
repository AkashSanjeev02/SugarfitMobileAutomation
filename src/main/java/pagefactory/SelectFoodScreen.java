package pagefactory;

import Utility.GenericUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectFoodScreen {

    private GenericUtility genericUtility;
    private AppiumDriver driver;

    public SelectFoodScreen(AppiumDriver driver) {
        this.driver = driver;
        genericUtility = new GenericUtility(driver);
        genericUtility.initPageElements(this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SELECT A MEAL\"]")
    private WebElement selectMealHeader;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint=\"Search for a Food Item\"]")
    private WebElement searchForFoodItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Log'])")
    private WebElement logButton;

    public void verifyThePresenceOfSelectMealScreen() {
        genericUtility.waitForElementVisible(selectMealHeader, 30);
    }

    public void searchForFoodItem(String foodItem) {
        genericUtility.type(searchForFoodItem, foodItem);
    }

    public void selectExactFood(String foodName) {
        List<WebElement> foodRows = driver.findElements(AppiumBy.className("android.view.ViewGroup"));

        for (WebElement row : foodRows) {
            String description = row.getAttribute("content-desc");

            if (description != null) {
                String cleanDescription = description.replace(",", "").replaceAll("\\s+", " ");

                if (cleanDescription.contains(foodName)) {
                    row.click();
                    return;
                }
            }
        }
        throw new RuntimeException("Could not find exact match for: " + foodName);
    }

    public void clickOnLog(){
        genericUtility.click(logButton);
    }
}
