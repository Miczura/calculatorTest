package com.calc.web.tests;

import com.calc.web.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTests extends TestBase{
    @Test
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


    @Test
    public void verifyCosPiCalculationReturnsCorrectResult(){

        CalculatorPage calcPage = new CalculatorPage();
        calcPage.clickRad()
                .clickCosinus()
                .clickPi()
                .clickRightParenthesis()
                .clickEquals();


        Assert.assertEquals(calcPage.getResult(), "-1");

    }

    @Test()
    public void verifySqrtCalculationReturnsCorrectResult(){

        CalculatorPage calcPage = new CalculatorPage();
        calcPage.clickSqrt()
                .enterNumber(8).enterNumber(1)
                .clickRightParenthesis()
                .clickEquals();

        Assert.assertEquals(calcPage.getResult(), "9");

    }
}
