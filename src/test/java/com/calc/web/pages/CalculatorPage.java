package com.calc.web.pages;

import com.calc.web.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalculatorPage {
    public CalculatorPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(id = "input")
    private WebElement inputField;


    @FindBy(id = "BtnPi")
    private WebElement piButton;

    @FindBy(id = "BtnCos")
    private WebElement cosinusButton;

    @FindBy(id = "BtnSqrt")
    private WebElement sqrtButton;

    @FindBy(id = "BtnParanL")
    private WebElement leftParenthesis;

    @FindBy(id = "BtnParanR")
    private WebElement rightParenthesis;

    @FindBy(id = "BtnDiv")
    private WebElement divideButton;

    @FindBy(id = "BtnMult")
    private WebElement multiplyButton;

    @FindBy(id = "BtnPlus")
    private WebElement addButton;

    @FindBy(id = "BtnClear")
    private WebElement clearButton;

    @FindBy(id = "BtnCalc")
    private WebElement equalsButton;

    @FindBy(xpath = "//*[@type='radio' and @value='rad']")
    private WebElement radButton;

    @FindBy(xpath = "//div[@id='hist']//span[contains(@class,'glyphicon glyphicon-chevron-down')]")
    private WebElement historyDropdown;

    public CalculatorPage clickRad(){
        radButton.click();
        return this;
    }
    public CalculatorPage clickCosinus(){
        cosinusButton.click();
        return this;
    }
    public CalculatorPage clickSqrt(){
        sqrtButton.click();
        return this;
    }
    public CalculatorPage clickPi(){
        piButton.click();
        return this;
    }
    public CalculatorPage enterNumber(int number){
        String xPath = number == 0 ? "//button[@id='Btn0']" : "//button[contains(text(),'"+number+"')]";
        WebElement numberButton = DriverManager.getWebDriver().findElement(By.xpath(xPath));;
        numberButton.click();
        return this;
    }
    public CalculatorPage clickLeftParenthesis(){
        leftParenthesis.click();
        return this;
    }
    public CalculatorPage clickRightParenthesis(){
        rightParenthesis.click();
        return this;
    }
    public CalculatorPage clickDivide(){
        divideButton.click();
        return this;
    }
    public CalculatorPage clickAdd(){
        addButton.click();
        return this;
    }

    public CalculatorPage clickMultiply(){
        multiplyButton.click();
        return this;
    }

    public CalculatorPage clearResult() {
        clearButton.click();
        return this;
    }

    public CalculatorPage enterExpression(String expression) {
        inputField.clear();
        inputField.sendKeys(expression);
        return this;
    }


    public CalculatorPage clickEquals() {
        String actualValue = inputField.getAttribute("value");
        equalsButton.click();
        waitForResultChange(actualValue);
        return this;
    }

    public String getResult() {
        return inputField.getAttribute("value");
    }


    public CalculatorPage openHistoryDropdown() {
        historyDropdown.click();
        return this;
    }

    private void waitForResultChange(String previousValue) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(5));
        wait.until(driver -> {
            String newValue = inputField.getAttribute("value");
            return !newValue.equals(previousValue);
        });
    }

    public List<String> getHistoryItems() {
        return DriverManager.getWebDriver()
                .findElements(By.xpath("//div[@id='histframe']//li/p[2]"))
                .stream()
                .map(WebElement::getText)
                .filter(s -> !s.trim().isEmpty())
                .toList();
    }
}
