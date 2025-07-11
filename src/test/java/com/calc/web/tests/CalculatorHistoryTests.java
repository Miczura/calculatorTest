package com.calc.web.tests;
import com.calc.web.listeners.SimpleRetryAnalyzer;
import com.calc.web.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorHistoryTests extends TestBase{

    @Test(retryAnalyzer = SimpleRetryAnalyzer.class)
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
