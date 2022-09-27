package com.cucubber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.cucubber.junit.driver.DriverManager.getDriver;
import static java.lang.String.format;

public class LoginPage extends BasePage {

    private static final String PAGE_TITLE_PATTERN = "//*[@class='content']/*[contains(@class,'') and contains(text(),'%s')]";
    private static final String BUTTON_TITLE_PATTERN = "//*[@id='%sSubmit']";

    private static final String FIELD_TITLE_PATTERN = "//input[@placeholder='%s']";
    private static final String IFRAME = "//*[@class='signin-iframe']";

    public boolean isPageWithTitleDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(PAGE_TITLE_PATTERN, title)));
    }

    private void switchToSignInIFrame() {
        getDriver().switchTo().frame(findElement(By.xpath(IFRAME)));
    }

    private void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    public LoginPage setFieldValue(String value, String field) {
        switchToSignInIFrame();
        findElement(By.xpath(format(FIELD_TITLE_PATTERN, field))).sendKeys(value);
        switchToDefaultContent();
        return this;
    }

    public LoginPage clickButton(String linkText) {
        switchToSignInIFrame();
        findElement(By.xpath(format(BUTTON_TITLE_PATTERN, linkText))).click();
        switchToDefaultContent();
        return this;
    }
}

