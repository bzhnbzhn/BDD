package com.cucubber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class LoginPage extends BasePage {

    private static final String PAGE_TITLE_PATTERN = "//*[@class='content']/*[contains(@class,'') and contains(text(),'%s')]";
    private static final String BUTTON_TITLE_PATTERN = "//*[@class='a-button-text' and contains(text(),'%s')]";
    private static final String FIELD_TITLE_PATTERN = "//input[@placeholder='%s']";

    public boolean isPageWithTitleDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(PAGE_TITLE_PATTERN, title)));
    }

    public WebElement field(String field) {
        iframe();
        return findElement(By.xpath(format(FIELD_TITLE_PATTERN, field)));
    }

    public WebElement button(String linkText) {
        return findElement(By.xpath(format(BUTTON_TITLE_PATTERN, linkText)));
    }
}

