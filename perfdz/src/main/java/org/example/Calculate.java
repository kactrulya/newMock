package org.example;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите первое число:");
            int num1 = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите второе число:");
            int num2 = Integer.parseInt(scanner.nextLine());

            System.out.println("Вы ввели число a = " + num1);
            System.out.println("Вы ввели число b = " + num2);

            System.out.println("Результат деления: " + divide(num1, num2));

        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод данных. Введите целые числа.");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль невозможно.");
        }
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return (double) a / b;
    }
}
