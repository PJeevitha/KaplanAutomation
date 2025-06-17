package com.tests;

import com.pages.alertsPageLocators;
import com.utils.LoggerUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;

public class demoQAAlerts {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void handleAlerts() throws InterruptedException {
        driver.get(alertsPageLocators.alertsURL);

        // Click Button to see alert
        WebElement alertBtn = driver.findElement(alertsPageLocators.alertButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertBtn);
        wait.until(ExpectedConditions.elementToBeClickable(alertBtn));
        alertBtn.click();
        Thread.sleep(3000);
        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
        LoggerUtil.green("Simple Alert Text: " + simpleAlert.getText());
        simpleAlert.accept();

        // On button click, alert will appear after 5 seconds
        WebElement timerBtn = driver.findElement(alertsPageLocators.timerAlertButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", timerBtn);
        wait.until(ExpectedConditions.elementToBeClickable(timerBtn));
        timerBtn.click();
        Thread.sleep(5000);
        Alert timedAlert = wait.until(ExpectedConditions.alertIsPresent());
        LoggerUtil.green("Timed Alert Text: " + timedAlert.getText());
        timedAlert.accept();
        Thread.sleep(2000);

        // On button click, confirm box will appear
        WebElement confirmBtn = driver.findElement(alertsPageLocators.confirmButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmBtn);
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();
        Thread.sleep(2000);
        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        LoggerUtil.green("Confirm Alert Text: " + confirmAlert.getText());
        confirmAlert.dismiss();

        // On button click, prompt box will appear
        WebElement promptBtn = driver.findElement(alertsPageLocators.promptButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promptBtn);
        wait.until(ExpectedConditions.elementToBeClickable(promptBtn));
        promptBtn.click();
        Thread.sleep(3000);
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
        LoggerUtil.green("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys("Jeevitha");
        promptAlert.accept();
        Thread.sleep(3000);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
