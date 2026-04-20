package org.example;

import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        //Random rand = new Random();
        //int a = 0;
        //int r = rand.nextInt(10) + 1;
        //int b = sc.nextInt();
        /* Задача 1
        if (a >= 0) {
            System.out.println("это число " + a + " положительное");
        }else{
            System.out.println("это число " + a + " отрицательное");
        }
        Задача 2
        if (a % 2 == 0) {
            System.out.println("четное");
        } else {
            System.out.println("нечетное");
        }
        Задача 3
        if (a < b) {
            System.out.println("Число "+ a + " меньше числа "+ b);
        } else {
            System.out.println("Число "+ b + " меньше числа "+ a);
        }
        Задача 4
        if ( a >= 18) {
            System.out.println("Добро пожаловать");
        } else {
            System.out.println("Доступ запрещен");
        }
        Задача 5
        if (a == 5){
            System.out.println("Отлично");
        } else if (a == 4) {
            System.out.println("Хорошо");
        } else if (a == 3) {
            System.out.println("Удовлетворительно");
        } else if (a == 2) {
            System.out.println("Плохо");
        } else {
            System.out.println("Очень плохо");
        }*/
       /* while (a!=r){
            System.out.println("Введи число");
             a = sc.nextInt();
             if (a == r) {
                 System.out.println("Ты угадал!");
             }
        }*/

        ArrayList<Integer> names = new ArrayList<>();

        Scanner sc = new Scanner(System.in);


        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите число");
            int a = sc.nextInt();
            names.add(a);

        }

        int maxsize = names.get(0);
        int minsize = names.get(0);

        for (int i = 1; i < names.size(); i++ ) {
            if ( names.get(i) > maxsize) maxsize = names.get(i);
            if ( names.get(i) < minsize) minsize = names.get(i);
        }

        System.out.println(maxsize);
        System.out.println(minsize);





        /*
        testMetod();
        ArrayList<Integer> names = new ArrayList<>();  //ArrayList — это динамический массив. Можно добавлять элементы, удалять и перебирать.
        names.add(10);
        names.add(100);
        names.add(1000);


        int maxValue = addArr(names);
        System.out.println("Максимальное число: " + maxValue);

        String text = "кот собака кот мышь собака";
        String[] words = text.split(" ");
        HashSet<String> wordss = new HashSet<>();
        for (String w : words) {
            wordss.add(w);
        }
        System.out.println(wordss);


        HashMap<String, Integer> ages = new HashMap<>();

        ages.put("Аня", 20);
        ages.put("Борис", 25);
        ages.put("Света", 19);

        System.out.println("Возраст Ани: " + ages.get("Аня"));

        for (String key : ages.keySet()) {
            System.out.println(key + " → " + ages.get(key));
        }


    }

    public static int addArr(ArrayList<Integer> arr){
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;

    }
    public static void testMetod(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите первое число");
            int b = sc.nextInt();
            System.out.println("Выберите действие (+, -, *, /)");
            String a = sc.next();
            System.out.println("Введите второе число");
            int c = sc.nextInt();
            if (a.equals("+")) {
                System.out.println("Ваш ответ");
                sum(b, c);
            } else if (a.equals("-")) {
                System.out.println("Ваш ответ");
                minus(b, c);
            } else if (a.equals("*")) {
                System.out.println("Ваш ответ");
                um(b, c);
            } else if (a.equals("/")) {
                System.out.println("Ваш ответ");
                del(b, c);
            } else {
                System.out.println("Неизвестная операция!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка!Нужно ввести число.");
        }
    }
    public static int sum(int a, int b){
        int sum = a + b;
        System.out.println(sum);
        return sum;
    }
    public static int minus(int a, int b){
        int minu = a - b;
        System.out.println(minu);
        return minu;
    }
    public static int um(int a, int b){
        int u = a * b;
        System.out.println(u);
        return u;
    }
    public static int del(int a, int b){
        int de = 0;
        if (b == 0) {
            System.out.println("Аааа, так делать нельзя!!!");
        } else {
            de = a / b;
            System.out.println(de);
        }
        return de;
    }
*/
    }
}