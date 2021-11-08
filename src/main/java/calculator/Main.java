package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        System.out.println(calculator.sum(first,second));
        System.out.println(calculator.subtraction(3, 2));
        System.out.println(calculator.multiplication(3, 2));
        System.out.println(calculator.split(3, 1));
    }
}
