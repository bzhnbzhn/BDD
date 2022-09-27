package com.cucubber.junit.pages;

import com.cucubber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.cucubber.junit.driver.DriverManager.getDriver;
import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String BOOK_DEPOSITORY_URL = "https://www.bookdepository.com/";
    private static final String TEXT_PATTERN = "//*[contains(text(),'%s')]";

    public void openWebsite() {
        DriverManager.getDriver().get(BOOK_DEPOSITORY_URL);
    }

    public WebElement menuSection(String linkText) {
        return findElement(By.xpath(format(TEXT_PATTERN, linkText)));
    }
}
