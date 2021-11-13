package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = 4;

    @Override
    public boolean retry(ITestResult arg0) {
        // TODO Auto-generated method stub
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}