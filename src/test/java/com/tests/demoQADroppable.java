package com.tests;

import com.pages.droppablePageLocators;
import com.utils.LoggerUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.time.Duration;

public class demoQADroppable {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testNotAcceptableDrop() throws InterruptedException {
        driver.get(droppablePageLocators.droppableURL);

        // Click on the "Accept" tab
        WebElement acceptTab = driver.findElement(droppablePageLocators.acceptTab);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", acceptTab);
        Thread.sleep(500);
        acceptTab.click();

        // Drag and Drop Not Acceptable
        WebElement notAcceptable = driver.findElement(droppablePageLocators.notAcceptable);
        WebElement dropHere = driver.findElement(droppablePageLocators.dropHereBox);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(notAcceptable, dropHere).perform();
        LoggerUtil.green("Not acceptable Drag and Drop done successfully");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
