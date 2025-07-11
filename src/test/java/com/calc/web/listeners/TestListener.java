package com.calc.web.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        ScreenShot.makeScreenShot();
    }
}
