package tests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class CalculatorSumTest {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] sumTest() {
        return new Object[][]{
                {2, 3, 5},
                {100, 200, 300},
                {10.3, 10.2, 20.5},
                {-2, -3, -5},
                {0, 0, 0},
                {1000000, 1, 1000001},
                {100, 200, 300},
                {0.3, 0.2, 0.5},
                {3, 10.2, 13.2},
                {3, 2, 5}
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

    @Test(dataProvider = "sumTest", description = "In this test we add the first and second numbers",
            retryAnalyzer = TestRetry.class, groups = {"Smoke"}, priority = 1, invocationCount = 2, threadPoolSize = 4)
    public void testSum(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.sum(firstNumber, secondNumber), expected);
    }
}

