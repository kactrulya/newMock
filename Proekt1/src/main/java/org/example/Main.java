package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        begin();
        //readStringFromUser();


    }


    public static void begin() {
        System.out.println("1. Ввести пример. \n2. Продолжить работу с предыдущим ответом. \n3. Выход. ");
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner

        // Считываем всю строку целиком (включая пробелы)
        String input = scanner.nextLine();


        switch (input) {
            case "1":
                System.out.println("Введите пример");
                primer();
                break;
            case "2":
                System.out.println("Пока не настроено");
                break;
            case "3":
                System.out.println("Пока");
                break;
            default:
                System.out.println("Здравствуй ");
        }


    }

    public static String readStringFromUser() {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner
        System.out.print("Введите строку: ");

        // Считываем всю строку целиком (включая пробелы)
        String input = scanner.nextLine();
        return input;

    }

    public static String primer() {

        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner
        // Считываем всю строку целиком (включая пробелы)
        String input = scanner.nextLine();

        String[] strArray = input.split(" ");
        String znak = strArray[1]; //вытягиваем знак действия
        int num1 = Integer.parseInt(strArray[0]);
        int num2 = Integer.parseInt(strArray[2]);


        switch (znak) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            case "/":
                System.out.println(num1 / num2);
                break;
            case "^":
                double otvet = Math.pow(num1, num2);
                System.out.println(otvet);
                break;
            case "!":
                int fac = 1;

                for (int i = 1; i <= num1; i++) {
                    fac = fac * i;
                }

                System.out.println(fac);
                break;
            case "?":
                if (num1 > num2){
                    System.out.println(num1 + " Больше чем " + num2);
                } else System.out.println(num2 + " Больше чем " + num1);
            default:
                System.out.println("Здравствуй ");
        }
        return input;
    }


}