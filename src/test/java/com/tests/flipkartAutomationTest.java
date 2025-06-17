package com.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import com.utils.LoggerUtil;
import java.util.List;
import com.pages.flipkartLocators;

public class flipkartAutomationTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void flipkartTestFlow() throws InterruptedException {
        driver.get(flipkartLocators.flipkartURL);

        // Close login popup if shown
        try {
            WebElement closePopup = driver.findElement(flipkartLocators.closePopup);
            closePopup.click();
        } catch (Exception e) {
            LoggerUtil.green("Login Popup not displayed");
        }

        // Hover: Fashion > Kids > Boys & Girls Jeans
        Actions actions = new Actions(driver);
        WebElement fashion = driver.findElement(flipkartLocators.fashionMenu);
        actions.moveToElement(fashion).perform();
        Thread.sleep(1000);

        WebElement kids = driver.findElement(flipkartLocators.kidsSubMenu);
        actions.moveToElement(kids).perform();
        Thread.sleep(1000);

        WebElement jeans = driver.findElement(flipkartLocators.jeansLink);
        jeans.click();

        LoggerUtil.green("Navigated to the Boys & Girls Jeans section successfully");

        // Sort by Price - Low to High
        WebElement sort = driver.findElement(flipkartLocators.priceLowToHigh);
        sort.click();
        Thread.sleep(5000);

        LoggerUtil.green("Sorted by price - low to high successfully");

        // Click the first item
        List<WebElement> productList = driver.findElements(flipkartLocators.productList);
        productList.get(0).click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        LoggerUtil.green("Opened the product successfully");

        // Get item name and price
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(flipkartLocators.productTitle));
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(flipkartLocators.productPrice));

        String itemName = nameElement.getText();
        String itemPrice = priceElement.getText();

        LoggerUtil.green("Item: " + itemName);
        LoggerUtil.green("Price: " + itemPrice);

        // Select size
        try {
            WebElement sizeBtn = driver.findElement(flipkartLocators.sizeBtn);
            sizeBtn.click();
        } catch (Exception e) {
            LoggerUtil.green("Size already selected");
        }

        // Click Add to Cart
        WebElement addToCart = driver.findElement(flipkartLocators.addToCartBtn);
        addToCart.click();
        LoggerUtil.green("Item added to cart successfully");

        // Verify item in cart
        WebElement cartItemName = driver.findElement(flipkartLocators.cartItemName);
        WebElement cartItemPrice = driver.findElement(flipkartLocators.cartItemPrice);

        String cartName = cartItemName.getText();
        String cartPrice = cartItemPrice.getText();

        Assert.assertTrue(cartName.contains(itemName.substring(0, 5)), "Item name mismatch");
        Assert.assertEquals(cartPrice, itemPrice, "Item price mismatch");
        LoggerUtil.green("----------------------------------------------------------------");
        LoggerUtil.green("The name and price of the product are verified successfully!");
        LoggerUtil.green("----------------------------------------------------------------");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
