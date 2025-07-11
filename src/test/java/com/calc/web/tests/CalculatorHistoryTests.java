package com.calc.web.tests;
import com.calc.web.listeners.SimpleRetryAnalyzer;
import com.calc.web.pages.CalculatorPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorHistoryTests extends TestBase{
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = SimpleRetryAnalyzer.class)
    @Description("Verify if history dropdown contains the last executed operations: 35*999+(100/4), cos(pi), and sqrt(81).")
    public void verifyHistoryDropdownContainsExecutedOperations(){
        //Given
        String firstCalculationInput = "35*999+(100/4)";
        String secondCalculationInput = "sqrt(81)";
        String thirdCalculationInput = "sqrt(16)";
        //When
        CalculatorPage calcPage = new CalculatorPage();
        calcPage.enterExpression(firstCalculationInput)
                .clickEquals()
                .clearResult()
                .enterExpression(secondCalculationInput)
                .clickEquals()
                .clearResult()
                .enterExpression(thirdCalculationInput)
                .clickEquals()
                .clearResult()
                .openHistoryDropdown();

        //Then
        var results = calcPage.getHistoryItems();

        Assert.assertEquals(results.get(0),thirdCalculationInput);
        Assert.assertEquals(results.get(1),secondCalculationInput);
        Assert.assertEquals(results.get(2),firstCalculationInput);
    }

}
