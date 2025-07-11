package com.calc.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";

    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException(MESSAGE_UNKNOWN_BROWSER);
        }
    }
}
