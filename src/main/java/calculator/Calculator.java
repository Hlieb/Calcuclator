package calculator;


import java.util.InputMismatchException;

public class Calculator {

    public double sum(double firstNumber, double secondNumber) {
        double result = 0;
        try {
            result = firstNumber + secondNumber;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect Input");
        }
        return result;
    }

    public double split(double firstNumber, double secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) {
            return -1;
        }
        return firstNumber / secondNumber;
    }

    public double multiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}

