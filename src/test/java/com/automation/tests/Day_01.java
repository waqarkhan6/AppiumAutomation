package com.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Day_01 {

    AppiumDriver<MobileElement>driver;

    @Test
    public void test1() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        // since we use android, put android. could be IOS
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        // version of your device
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
        // name of the device
        // if its real device, you need to use udid parameter
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");
        // either you can specify app --> path/to/the/app.apk
        // or, if app is already installed, you need to specify appActivity and AppPackage
        // this ino you can find in the iinternet, at work - from developers
        // otherwise, you can use apk info app to find this information
        desiredCapabilities.setCapability("appPackage","com.android.calculator2");
        // set your applications package name
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        // set your applications Mainactivity i.e the launcher activity name.
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(3000);
        MobileElement digit2 = driver.findElement(By.id(""));
        // MobileBy = is a child class of By
        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        MobileElement result = driver.findElement(By.id(""));

        digit2.clear();
        plus.click();
        digit2.click();
        equals.click();

        String resultText = result.getText(); // read the text of result.
        Assert.assertEquals("4", resultText); // assert that result is equals to 4.

        driver.closeApp();

    }
}
