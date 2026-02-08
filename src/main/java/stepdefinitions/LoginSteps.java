package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.base.BaseClass;
import pagefactory.EnterOtpScreen;
import pagefactory.HomeScreen;
import pagefactory.LoginScreen;
import org.testng.Assert;

public class LoginSteps extends BaseClass {

    private LoginScreen loginScreen;
    private EnterOtpScreen enterOtpScreen;
    private HomeScreen homeScreen;

    @Given("Launch the sugar.fit application")
    public void launch_the_sugar_fit_application() {
        // Initialize the LoginScreen page object
        loginScreen = new LoginScreen(getDriver());
        // Verify that the app has launched by checking for a key element on the login screen
        loginScreen.verifyThePresenceOfLoginScreen();
    }

    @When("Verify the login screen is displayed")
    public void verify_the_login_screen_is_displayed() {
        // This step is already covered in the previous step, but we can add an additional assertion here if needed
        loginScreen.verifyThePresenceOfLoginScreen();
    }

//    @Then("Verify the average app load time is within acceptable limits")
//    public void verify_the_average_app_load_time_is_within_acceptable_limits() {
//
//    }

    @Given("Launch the sugar.fit application and Verify the login screen is displayed")
    public void launch_the_sugar_fit_application_and_Verify_the_login_screen_is_displayed() {
        launch_the_sugar_fit_application();
        loginScreen.verifyThePresenceOfLoginScreen();
    }

    @When("Enter phone number {string}")
    public void enter_phone_number(String string) {
        loginScreen.enterPhoneNumber(string);
    }

    @When("Enter OTP {string}")
    public void enter_OTP(String OTP) {
        enterOtpScreen.enterOTP(OTP);
    }

    @When("Click the login button")
    public void click_the_login_button() {

    }

    @Then("Verify the user is redirected to HomeScreen")
    public void verify_the_user_is_redirected_to_HomeScreen() {

    }

    @When("Verify the presence of Enter OTP screen")
    public void verify_the_presence_of_Enter_OTP_screen() {
        enterOtpScreen = new EnterOtpScreen(getDriver());
        enterOtpScreen.verifyThePresenceOfEnterOtpScreen();
    }

    @Then("Verify the presence of Home screen")
    public void verify_the_presence_of_Home_screen() {
        homeScreen = new HomeScreen(getDriver());
        homeScreen.verifyThePresenceOfHomeScreen();
    }

    @When("Click the Send Verification Code button")
    public void click_the_Send_Verification_Code_button() {
      loginScreen.clickSendVerificationCodeButton();
    }


}
