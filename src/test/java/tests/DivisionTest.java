package tests;

import Calculator.Calculator;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

@Listeners(TestListener.class)

public class DivisionTest {
    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] divisionNum() {
        return new Object[][]{
                {80, 20, 4},
                {1, 2, 0.5},
                {400, 200, 2},
                {4.8, 1.6, 2.9999999999999996},
                {-4, -2, 2},
                {105, 105, 1},
                {8, 1, 8},
                {55, 10, 5.5},
                {12, 6, 2},
                {0.5, 0.5, 1}
        };
    }

    @BeforeMethod
    public void calculation() {
        System.out.println("Start");
    }

    @AfterMethod
    public void finish() {
        System.out.println("End");
    }

    @Test(dataProvider = "divisionNum", description = "This test divides first number on second number",
            retryAnalyzer = TestRetry.class, groups = {"Smoke"}, invocationCount = 4, threadPoolSize = 4)
    public void divideTest(double firstNumber, double secondNumber, double expected){
        Assert.assertEquals(calculator.division(firstNumber,secondNumber), expected);
    }
}
