package org.example.drivers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.ConfigLoader;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;

public class DriverSetup {
    protected AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setup() {
        if (driver == null) {
            try {
                ConfigLoader configLoader = new ConfigLoader();
                DesiredCapabilities capabilities = getCapabilities(configLoader);
                driver = new AndroidDriver<>(new URL(configLoader.get("serverUrl")), capabilities);
            } catch (Exception e) {
                throw new RuntimeException("Error during driver setup: " + e.getMessage(), e);
            }
        }
    }


    private DesiredCapabilities getCapabilities(ConfigLoader configLoader) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", configLoader.get("platformName"));
        capabilities.setCapability("platformVersion", configLoader.get("platformVersion"));
        capabilities.setCapability("deviceName", configLoader.get("deviceName"));
        capabilities.setCapability("udid", configLoader.get("udid"));
        capabilities.setCapability("automationName", configLoader.get("automationName"));
        capabilities.setCapability("app", configLoader.get("appPath"));
        capabilities.setCapability("appActivity", configLoader.get("appActivity"));
        capabilities.setCapability("appWaitActivity", configLoader.get("appWaitActivity"));

        return capabilities;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}