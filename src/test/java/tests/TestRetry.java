package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {

    private int retryNum = 0;
    private int maxRetryNum = 5;

    @Override
    public boolean retry(ITestResult arg0) {
        if (retryNum < maxRetryNum) {
            retryNum++;
            return true;
        }
        return false;
    }
}
