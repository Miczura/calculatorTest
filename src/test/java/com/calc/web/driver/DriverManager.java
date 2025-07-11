package com.calc.web.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver.get() == null) {
            String browserName = System.getProperty("browser", "chrome").toUpperCase();
            BrowserType browserType = BrowserType.valueOf(browserName);
            driver.set(BrowserFactory.getBrowser(browserType));;
        }

        return driver.get();
    }

    public static void disposeDriver() {
//        driver.close();
//        driver.quit();
//        driver = null;

        WebDriver drv = driver.get();
        if (drv != null) {
            drv.quit();
            driver.remove();
        }
    }
}
