package tests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class CalculatorMultiplicationTest {
    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] multiplicationData() {
        return new Object[][]{
                {4.2, 0, 0},
                {100, 200.1, 20010},
                {130, 130, 16900},
                {0, 1, 0},
                {200, 1.1, 220.00000000000003},
                {11111111, 1, 11111111},
                {1.1, 100, 110.00000000000001},
                {-1, -1, 1},
                {2, -2, -4},
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

    @Test(dataProvider = "multiplicationData", description = "In this test, we multiply the first and second numbers",
            retryAnalyzer = TestRetry.class, groups = {"Smoke"}, priority = 1, invocationCount = 5, threadPoolSize = 4)
    public void multiplicationTest(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.multiplication(firstNumber, secondNumber), expected);
    }
}
