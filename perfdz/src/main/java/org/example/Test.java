package org.example;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите положительное число");
        String str = scanner.nextLine();

        Scanner sc = new Scanner(System.in);
        System.out.println("Вы ввели: " + str);
        boolean isPalindrome = true;
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            System.out.println("Число " + str + " является палиндромом");
        } else {
            System.out.println("Число " + str + " не палиндром");
        }


    }
}
