package tests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class CalculatorSubstractionTest {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] substractionData() {
        return new Object[][]{
                {2, 3, -1},
                {200, 100, 100},
                {10.5, 10.2, 0.3000000000000007},
                {20.1, 100, -79.9},
                {1000000, 100000, 900000},
                {-100000, -100, -99900},
                {11, 10.2, 0.8000000000000007},
                {10.0, 10.0, 0}
        };
    }

    @BeforeMethod
    public void start() {
        System.out.println("Test started");
    }

    @AfterMethod
    public void end() {
        System.out.println("Test finished");
    }

    @Test(dataProvider = "substractionData", description = "In this test we subtract the second number from the first",
            retryAnalyzer = TestRetry.class, groups = {"Smoke"}, priority = 1, invocationCount = 3, threadPoolSize = 4)
    public void testSum(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.subtraction(firstNumber, secondNumber), expected);
    }
}



