package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.base.BaseClass;
import pagefactory.*;

public class HomeSteps extends BaseClass {

    private LoginScreen loginScreen = new LoginScreen(getDriver());
    private EnterOtpScreen enterOtpScreen = new EnterOtpScreen(getDriver());
    private HomeScreen homeScreen = new HomeScreen(getDriver());
    private LoginSteps loginSteps = new LoginSteps();
    private WhatYouLikeToLogScreen whatYouLikeToLogScreen = new WhatYouLikeToLogScreen(getDriver());
    private SelectMealScreen selectMealScreen = new SelectMealScreen(getDriver());
    private LogMethodScreen logMethodScreen = new LogMethodScreen(getDriver());
    private SelectFoodScreen selectFoodScreen = new SelectFoodScreen(getDriver());
    private MailDairyScreen mailDairyScreen = new MailDairyScreen(getDriver());

    @Given("User is Logged in and on the Home screen: {string} {string}")
    public void user_is_Logged_in_and_on_the_Home_screen(String PhoneNumber, String Otp) {
        loginSteps.launch_the_sugar_fit_application_and_Verify_the_login_screen_is_displayed();
        loginSteps.enter_phone_number(PhoneNumber);
        loginSteps.click_the_Send_Verification_Code_button();
        loginSteps.verify_the_presence_of_Enter_OTP_screen();
        loginSteps.enter_OTP(Otp);
        loginSteps.verify_the_presence_of_Home_screen();
    }

    @Given("the user taps on the Plus icon at the bottom tab bar")
    public void the_user_taps_on_the_Plus_icon_at_the_bottom_tab_bar() {
       homeScreen.clickOnPlusIconToAddMeal();
    }

    @Given("the user selects from the logging options {string}")
    public void the_user_selects_from_the_logging_options(String Food) {
        whatYouLikeToLogScreen.verifyThePresenceOfWhatYouLikeToLogScreen();
        whatYouLikeToLogScreen.clickOnFoodLogHeader();
    }

    @When("the user selects {string} from the Select Method screen")
    public void the_user_selects_from_the_Select_Method_screen(String LogManually) {
        logMethodScreen.verifyThePresenceOfLogMethodScreen();
        logMethodScreen.selectMethod(LogManually);
    }

    @When("the user selects the {string} meal slot")
    public void the_user_selects_the_meal_slot(String PreBreakfast) {
        selectMealScreen.verifyThePresenceOfSelectMealScreen();
        selectMealScreen.selectMeal(PreBreakfast);
    }

    @When("the user searches and Selects for {string} in the search bar")
    public void the_user_searches_for_in_the_search_bar(String FoodItem) {
        selectFoodScreen.verifyThePresenceOfSelectMealScreen();
        selectFoodScreen.searchForFoodItem(FoodItem);
    }

    @When("the user taps on the Log button")
    public void the_user_taps_on_the_Log_button() {
        selectFoodScreen.clickOnLog();
    }

    @When("the message ThingsYoureDoingRight should be visible")
    public void the_message_ThingsYoureDoingRight_should_be_visible() {
       mailDairyScreen.verifyThePresenceOfMailDairyScreen();
    }
}
