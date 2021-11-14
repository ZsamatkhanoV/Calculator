package tests;

import Calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class SubtractionTest {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] subtractNum() {
        return new Object[][]{
                {5, 5, 0},
                {10, 20, -10},
                {400, 250, 150},
                {10.5, 10.4, 0.09999999999999964},
                {-5, -5, 0},
                {207, 107, 100},
                {0, 0, 0},
                {0.5, 10, -9.5},
        };
    }

    @BeforeMethod
    public void calculation(){
        System.out.println("Start");
    }

    @AfterMethod
    public void finish(){
        System.out.println("End");
    }

    @Test(dataProvider = "subtractNum", description = "This test subtracts second number from the first",
            retryAnalyzer = TestRetry.class, groups = {"Smoke"}, priority = 2, invocationCount = 2, threadPoolSize = 4)
    public void subtractNumTest(double firstNum, double secondNum, double expected){
        Assert.assertEquals(calculator.subtraction(firstNum,secondNum), expected);
    }
}
