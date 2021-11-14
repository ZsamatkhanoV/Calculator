package tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(String.format("============================= START %s =============================", iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(String.format("============================= FINISHED %s Duration: %ss =============================", iTestResult.getName(),
                getElapsedTime(iTestResult)));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(String.format("============================= FAILED %s Duration: %ss =============================", iTestResult.getName(),
                getElapsedTime(iTestResult)));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(String.format("============================= SKIPPED %s =============================", iTestResult.getName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private long getElapsedTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toMillis(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
