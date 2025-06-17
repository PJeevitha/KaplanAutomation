package com.tests;

import com.pages.browserWindowLocators;
import com.pages.droppablePageLocators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Set;

public class demoQABrowserWindow {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void handleNewWindow() throws InterruptedException {
        driver.get(browserWindowLocators.browserWindowURL);
        String parentWindow = driver.getWindowHandle();

        WebElement newWindowBtn = driver.findElement(browserWindowLocators.newWindowButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", newWindowBtn);
        Thread.sleep(500);
        newWindowBtn.click();
        Thread.sleep(2000);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        WebElement heading = driver.findElement(browserWindowLocators.newWindowHeading);
        String actualText = heading.getText();
        System.out.println("Text in new window: " + actualText);
        Assert.assertEquals(actualText, "This is a sample page", "Text not matched!");
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
