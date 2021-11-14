package tests;

import Calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class MultiplicationTest {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] multiplicateNum(){
        return new Object[][]{
                {5, 5, 25},
                {10, 20, 200},
                {400, 0, 0},
                {10.5, 2, 21},
                {-5, -6, 30},
                {20, 1.5, 30},
                {0, 0, 0},
                {0.5, -10, -5},
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

    @Test(dataProvider = "multiplicateNum", description = "This test multiplies first number on second number",
            retryAnalyzer = TestRetry.class, groups = {"Smoke"}, priority = 1, invocationCount = 2, threadPoolSize = 4)
    public void multiplicateNumTest(double firstNum, double secondNum, double expected){
        Assert.assertEquals(calculator.multiplication(firstNum,secondNum), expected);
    }
}
