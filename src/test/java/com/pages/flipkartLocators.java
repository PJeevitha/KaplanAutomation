package com.pages;

import org.openqa.selenium.By;

public class flipkartLocators {

    public static final String flipkartURL = "https://www.flipkart.com";

    public static final By closePopup = By.xpath("//div[contains(@class,'_3CYmv5')]//span[text()='✕']");

    public static final By fashionMenu = By.xpath("//span[text()='Fashion']");
    public static final By kidsSubMenu = By.xpath("//a[text()='Kids']");
    public static final By jeansLink = By.linkText("Boys & Girls Jeans");

    public static final By priceLowToHigh = By.xpath("//div[contains(text(),'Price -- Low to High')]");

    public static final By productList = By.className("_53J4C-");

    public static final By productTitle = By.cssSelector(".VU-ZEz");
    public static final By productPrice = By.cssSelector(".Nx9bqj.CxhGGd");
    public static final By sizeBtn = By.xpath("//a[contains(@class, '_1fGeJ5')]");
    public static final By addToCartBtn = By.xpath("//button[text()='Add to cart']");

    public static final By cartItemName = By.cssSelector(".T2CNXf.QqLTQ-");
    public static final By cartItemPrice = By.cssSelector(".LAlF6k.re6bBo");
}
