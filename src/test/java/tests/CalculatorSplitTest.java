package tests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class CalculatorSplitTest {
    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] splitData() {
        return new Object[][]{
                {100, 200, 0.5},
                {130, 130, 1},
                {130, 10, 13},
                {13.0, 10, 1.3},
                {1.3, 1, 1.3},
                {1.3, 1.3, 1},
                {4, 0, -1},
                {0, 4, -1},
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

    @Test(dataProvider = "splitData", description = "In this test, we split the first and second numbers",
            retryAnalyzer = TestRetry.class, groups = {"Smoke"}, invocationCount = 5, threadPoolSize = 4)
    public void splitTest(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.split(firstNumber, secondNumber), expected);
    }
}
