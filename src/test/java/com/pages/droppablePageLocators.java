package com.pages;

import org.openqa.selenium.By;

public class droppablePageLocators {
    public static final String droppableURL = "https://demoqa.com/droppable";

    public static final By acceptTab = By.id("droppableExample-tab-accept");
    public static final By notAcceptable = By.id("notAcceptable");
    public static final By dropHereBox = By.cssSelector("#acceptDropContainer #droppable");
}
