package com.cucubber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class CartPage extends BasePage {

    private static final String BUTTON_PATTERN = "//*[contains(text(),'%s')]";

    public WebElement button(String linkText) {
        return findElement(By.xpath(format(BUTTON_PATTERN, linkText)));
    }
}
