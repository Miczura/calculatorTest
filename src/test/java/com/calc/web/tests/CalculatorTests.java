package com.calc.web.tests;

import com.calc.web.listeners.SimpleRetryAnalyzer;
import com.calc.web.pages.CalculatorPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTests extends TestBase{

    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = SimpleRetryAnalyzer.class)
    @Description("Calculate complex expression 35*999+(100/4) and verify the result equals 34990.")
    public void verifyCalculateComplexExpressionReturnsCorrectResult(){

        CalculatorPage calcPage = new CalculatorPage();
        calcPage.enterNumber(3).enterNumber(5)
                .clickMultiply()
                .enterNumber(9).enterNumber(9).enterNumber(9)
                .clickAdd()
                .clickLeftParenthesis()
                .enterNumber(1).enterNumber(0).enterNumber(0)
                .clickDivide()
                .enterNumber(4)
                .clickRightParenthesis()
                .clickEquals();

        Assert.assertEquals(calcPage.getResult(), "34990");

    }

    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = SimpleRetryAnalyzer.class)
    @Description("Calculate cos(pi) using radians mode and verify the result equals -1.")
    public void verifyCosPiCalculationReturnsCorrectResult(){

        CalculatorPage calcPage = new CalculatorPage();
        calcPage.clickRad()
                .clickCosinus()
                .clickPi()
                .clickRightParenthesis()
                .clickEquals();


        Assert.assertEquals(calcPage.getResult(), "-1");

    }
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = SimpleRetryAnalyzer.class)
    @Description("Calculate sqrt(81) and verify the result equals 9.")
    public void verifySqrtCalculationReturnsCorrectResult(){

        CalculatorPage calcPage = new CalculatorPage();
        calcPage.clickSqrt()
                .enterNumber(8).enterNumber(1)
                .clickRightParenthesis()
                .clickEquals();

        Assert.assertEquals(calcPage.getResult(), "9");

    }
}
