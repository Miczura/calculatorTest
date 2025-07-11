package com.calc.web.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(BrowserType.CHROME);
        }

        return driver;
    }

    public static void disposeDriver() {
//        driver.close();
        driver.quit();
        driver = null;
    }
}
