package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Integer c;
//        int a = 365;
//        int b = 366;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите год в формате 'yyyy'");
//        c = Integer.valueOf(sc.nextLine());
//        System.out.println("Вы ввели:" + c);
//
//        if (((c % 2) == 0) || ((c % 4 == 0) && (c % 100 != 0))){
//
//            System.out.println("Количество дней в году: " + b + " високосный");
//        } else {
//            System.out.println("Количество дней в году: " + a);
//        }
//        sc.close();


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = str.length();
        System.out.println("Длина строки = " + length);
        char[] symbols = new char[length];
        char[] symbolsstr = str.toCharArray();
        for(int i = 1; i <= length; i++){
            symbols[length-i] = symbolsstr[i-1];
        }
        String newStr = new String(symbols);


        System.out.println(symbolsstr[1]);
    }
}