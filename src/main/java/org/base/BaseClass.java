package org.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    // Device and App Configuration Fields
    public static String androidDeviceName;
    public static String androidAppFileName;
    public static String androidAppPackage;
    public static String androidAppActivity;
    public static String androidPlatformVersion;
    public static String platform;

    public AppiumDriver getDriver() {
        return driver.get();
    }

    /**
     * Initializes the Android Driver for a real device using
     * capabilities provided via TestNG XML.
     */
    public void androidRealDeviceFromXML() throws MalformedURLException {
        UiAutomator2Options capAndroid = new UiAutomator2Options();

        // Basic Appium Configuration
        capAndroid.setAutomationName("UiAutomator2");
        capAndroid.setDeviceName(androidDeviceName);
        capAndroid.setUdid(androidDeviceName);
        capAndroid.setNoReset(true); // Preserves app data like login sessions
        capAndroid.setAutoGrantPermissions(true);

        // Set Platform Version if provided
        if (androidPlatformVersion != null && !androidPlatformVersion.isEmpty()) {
            capAndroid.setPlatformVersion(androidPlatformVersion);
        }

        // Logic to handle APK installation vs. Launching an existing app
        if (androidAppFileName != null && !androidAppFileName.isEmpty()) {
            File apkFile = new File(System.getProperty("user.dir") + "/" + androidAppFileName);
            if (apkFile.exists()) {
                capAndroid.setApp(apkFile.getAbsolutePath());
                System.out.println("Using APK for installation: " + apkFile.getAbsolutePath());
            } else {
                System.out.println("APK not found at path. Attempting to launch by Package/Activity.");
            }
        }

        // Mandatory check for Package and Activity when running on real devices
        if (androidAppPackage != null && !androidAppPackage.isEmpty() &&
                androidAppActivity != null && !androidAppActivity.isEmpty()) {

            capAndroid.setAppPackage(androidAppPackage);
            capAndroid.setAppActivity(androidAppActivity);
            System.out.println("Launching App: " + androidAppPackage + " / " + androidAppActivity);
        } else {
            throw new RuntimeException("Error: appPackage and appActivity must be provided for real device execution.");
        }

        // Initialize the driver
        // Ensure your Appium Server is running at this URL
        driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capAndroid));
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Clean up the ThreadLocal reference
        }
    }
}