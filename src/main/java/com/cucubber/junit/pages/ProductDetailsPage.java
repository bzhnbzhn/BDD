package com.cucubber.junit.pages;

import com.cucubber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static java.lang.String.format;

public class ProductDetailsPage extends BasePage {

    private static final String BUTTON_IN_PDP_PATTERN = "//*[contains(text(),'%s')]";
    private static final String BUTTON_IN_PDP_POP_UP_PATTERN = "//*[@class='basket-info']//*[contains(text(),'%s')]";

    public WebElement buttonInPDP(String linkText) {
        return findElement(By.xpath(format(BUTTON_IN_PDP_PATTERN, linkText)));
    }

    public WebElement buttonInPDPPopUp(String linkText) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return findElement(By.xpath(format(BUTTON_IN_PDP_POP_UP_PATTERN, linkText)));
    }
}
