package com.calc.web.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static void handleConsentIfPresent(WebDriver driver, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        try {
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Welcome to 0calc.com']/following::button[./p[text()='Do not consent']]")));
            consentButton.click();
            System.out.println("Consent removed.");
        } catch (TimeoutException e) {
            System.out.println("No consent we can proceed");
        }
    }
}
