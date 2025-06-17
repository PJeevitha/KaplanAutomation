package com.pages;

import org.openqa.selenium.By;

public class nestedFrameLocators {

    public static final String nestedFramesURL = "https://demoqa.com/nestedframes";

    public static final String parentFrameName = "frame1";  // Frame name
    public static final By childFrameTag = By.tagName("iframe"); // Child frame inside parent
    public static final By childTextTag = By.tagName("p"); // Paragraph inside child frame

}
