package com.cucubber.junit.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class DocsPage extends BasePage {

    private static final String PAGE_TITLE_PATTERN = "//*[@class='content']/*[contains(@class,'') and contains(text(),'%s')]";

    public boolean isPageWithTitleDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(PAGE_TITLE_PATTERN, title)));
    }
}
