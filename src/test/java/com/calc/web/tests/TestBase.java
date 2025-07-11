package com.calc.web.tests;

import com.calc.web.driver.DriverManager;
import com.calc.web.driver.DriverUtils;
import com.calc.web.utils.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.calc.web.navigation.ApplicationURL.APPLICATION_URL;

public class TestBase {
    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
        Utils.handleConsentIfPresent(DriverManager.getWebDriver(),5);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
