package runner;

import Utility.RetryAnalyzer;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.base.BaseClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;

@CucumberOptions(
        features = "src/main/java/features/Login.feature",
        glue = {"stepdefinitions"},
        tags = {"@login-success"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class TestRunnerAndroid extends AbstractTestNGCucumberTests {

    BaseClass base = new BaseClass();

    @Parameters({"platform", "deviceName", "appFileName", "appPackage", "appActivity", "platformVersion"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(
            String platform,
            String deviceName,
            String appFileName,
            String appPackage,
            String appActivity,
            String platformVersion
    ) throws MalformedURLException {

        // Assign all parameters to the BaseClass instance
        base.platform = platform;
        base.androidDeviceName = deviceName;
        base.androidAppFileName = appFileName;
        base.androidAppPackage = appPackage;
        base.androidAppActivity = appActivity;
        base.androidPlatformVersion = platformVersion;

        System.out.println("Platform:        " + platform);
        System.out.println("Device Name:     " + deviceName);
        System.out.println("App Package:     " + appPackage);
        System.out.println("App Activity:    " + appActivity);

        if ("android".equalsIgnoreCase(platform)) {
            // Logic to check if we are installing an APK or launching an installed app
            if (appFileName != null && !appFileName.isEmpty()) {
                File apkFile = new File(System.getProperty("user.dir") + "/" + appFileName);
                if (apkFile.exists()) {
                    System.out.println("Launching with APK.");
                }
            } else {
                System.out.println("Launching installed app on real device.");
            }
            base.androidRealDeviceFromXML();
        } else {
            throw new RuntimeException("Unsupported platform: " + platform);
        }
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}