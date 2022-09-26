package com.cucubber.junit.pages;

import com.cucubber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.cucubber.junit.driver.DriverManager.getDriver;

public abstract class BasePage {

    private static final String IFRAME = "//*[@class='signin-iframe']";

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }

    public static void iframe() {
        getDriver().switchTo().frame(findElement(By.xpath(IFRAME)));
    }
}
