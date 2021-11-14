package tests;

import Calculator.Calculator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class SumTest {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] sumNum() {
        return new Object[][]{
                {5, 6, 11},
                {10, 20, 30},
                {100, 200, 300},
                {10.5, 10.6, 21.1},
                {-5, -6, -11},
                {207, 207, 414},
                {0, 0, 0},
                {0.5, 10, 10.5},
                {7, 6, 13},
                {0.5, 0.6, 1.1}
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

    @Test(dataProvider = "sumNum", description = "This test sum's first and second numbers",
            retryAnalyzer = TestRetry.class, groups = {"Smoke"}, priority = 1, invocationCount = 3, threadPoolSize = 4)
    public void sumNumTest(double firstNum, double secondNum, double expected) {
        Assert.assertEquals(calculator.sum(firstNum,secondNum), expected);
    }
}
