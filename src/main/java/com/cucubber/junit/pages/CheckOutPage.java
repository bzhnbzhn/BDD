package com.cucubber.junit.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class CheckOutPage extends BasePage {

    private static final String VALUE_PATTERN = "//*[@class='sidebar right order-summary-full-width']//*[@class='wrapper']//*[contains(@aria-label, '%s')]//*[contains(@class, 'text-right')]";

    public String value(String linkText) {
        return findElement(By.xpath(format(VALUE_PATTERN, linkText))).getText();
    }
}
