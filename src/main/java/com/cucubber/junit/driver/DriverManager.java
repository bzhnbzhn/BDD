package com.cucubber.junit.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.Optional;

public class DriverManager {

    private static ChromeDriver driver;

    private DriverManager() {
    }

    public static void setupDriver() {
        if (Objects.equals(System.getProperty("os.name"), "Mac OS X")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriverW.exe");
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(WebDriver::quit);
    }

}