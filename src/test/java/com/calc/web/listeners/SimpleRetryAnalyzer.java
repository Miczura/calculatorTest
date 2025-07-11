package com.calc.web.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class SimpleRetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        System.out.println("Retrying " + retryCount);
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
