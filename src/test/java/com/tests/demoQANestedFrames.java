package com.tests;

import com.pages.nestedFrameLocators;
import com.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class demoQANestedFrames {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void handleNestedFrames() {
        driver.get(nestedFrameLocators.nestedFramesURL);

        // Switch to parent frame
        driver.switchTo().frame(nestedFrameLocators.parentFrameName);

        // Switch to child frame inside parent frame
        WebElement childFrame = driver.findElement(nestedFrameLocators.childFrameTag);
        driver.switchTo().frame(childFrame);

        // Get the text from child frame
        String childText = driver.findElement(nestedFrameLocators.childTextTag).getText();
        LoggerUtil.green("Child Frame Text Output: " + childText);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
