package com.cucubber.junit.pages;

import com.cucubber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String BOOK_DEPOSITORY_URL = "https://www.bookdepository.com/";
    private static final String TEXT_PATTERN = "//*[contains(text(),'%s')]";
    private static final String SEARCH_FIELD = "//*[@placeholder='Search for books by keyword / title / author / ISBN']";

    public void openWebsite() {
        DriverManager.getDriver().get(BOOK_DEPOSITORY_URL);
    }

    public void openProductDetailsPage(String productIdOrName){
        findElement(By.xpath(format(SEARCH_FIELD))).sendKeys(productIdOrName);
    }

    public WebElement menuSection(String linkText) {
        return findElement(By.xpath(format(TEXT_PATTERN, linkText)));
    }
}