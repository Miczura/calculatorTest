# Calculator Test Framework

This is a basic test automation framework built with **Java 17**, **Selenium WebDriver**, and **TestNG**.  
It is designed for testing a simple web calculator application.

## 🔧 Technologies Used

- **Java 17**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)** design pattern

## ⭐ Features
- **Local run only**
- **Supports Chrome and Firefox browsers:** Chrome will be selected by default
- **Supports parallel test execution:** 2 threads by default for faster feedback.
- **Automatic WebDriver management:** Drivers are downloaded and managed automatically by Selenium.
- **Basic retry and screenShot mechanisms:**
- **Basic reporting:** Allure integration for better test insights.


## 🚀 How to Run Tests

1. **Clone the repository:**

   ```
   git clone https://github.com/Miczura/calculatorTest.git
   
2. **Import the project into your favorite IDE (e.g., IntelliJ IDEA) as a Maven project.**
3. **Compile project:**
   ```
   mvn clean compile
4. **Run the entire test suite:**
   ```
   mvn clean test
5. **Run single test class**
   ```
   mvn clean test -Dtest=className
6. **Run basic allure report**
   ```
   mvn allure:serve
7. **Browser selection** 
   ```
   mvn clean test -Dbrowser=firefox
Tested on:

Win 10, CH, FF, Java 17.0.6, Maven 3.9.9

Ubuntu 24.04, CH, Java 17.0.15, Maven 3.8.7




