package com.cucubber.junit.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;


public class ContactPage extends BasePage {

    private static final String ADDRESS = "//*[@class='font-size-22']";

    public static String getAddress() {
        return findElement(By.xpath(format(ADDRESS))).getText();
    }
}
