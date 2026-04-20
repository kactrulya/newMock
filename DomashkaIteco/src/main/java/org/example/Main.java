package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        String city = "Stavropol";
        int population = 500000;
        byte unemployed = 25;
        char section = 'A';
        int place = 7;
        float price = 444.223F;
        String name = "Nikita";
        int age = 27;
        double height = 188.67F;
        char carChar1 = 'B';
        char carChar2 = 'B';
        char carChar3 = 'O';
        int carNumber = 235;
        float carWeight = 500.345F;
        String companyName = "Magnit";
        int doxod = 574843433;
        short dolya = 30;
        char factor = 'A';
        int group = 1;
        int factorD = 30;
        String university = "MGU";
        int students = 50000;
        int expelled = 25;
        char movieRating = 'C';
        int copiesSold = 200000;
        int rating = 67;
        String brandName = "D&G";
        long count = 10000000;
        int sale = 100;
        char category = 'M';
        int barcode = 2893339;
        int sold = 37;
        System.out.printf("%s - Город, %d - Население, %d - процент безработных \n", city, population, unemployed);
        System.out.printf("%s - секция на трибуне, %d - место, %.2f - стоимость билета \n", section, place, price);
        System.out.printf("%s - имя, %d - возраст, %.2f - рост \n", name, age, height);
        System.out.printf("%s%s%s - буквенный номер машины, %d - числовой номер машины, %.2f - вес автомобиля \n", carChar1, carChar2, carChar3, carNumber, carWeight);
        System.out.printf("%s - название компании, %d - годовой доход, %d - доля на рынке \n", companyName, doxod, dolya);
        System.out.printf("%s - резус фактор, %d - группа крови, %d - доля людей с этой группой крови \n", factor, group, factorD);
        System.out.printf("%s - название универа, %d - число студентов, %d - доля отчисленных \n", university, students, expelled);
        System.out.printf("%s - рейтинг фильма, %d - копий продано, %d - рейтинг \n", movieRating, copiesSold, rating);
        System.out.printf("%s - название бренда, %d - проивзедено товара, %d - процент продаж \n", brandName, count, sale);
        System.out.printf("%s - категория товара, %d - штрих код, %d - процент покупателей старше 30 \n", category, barcode, sold); */



        /*int[] array = {3, 22, 1, 13, 4, 6, 16, 5};
        //четные числа
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)

        System.out.print(array[i] + " ");
        }

        //Двузначные числа
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 9)
                System.out.println(array[i] + " ");
        }


        //наибольше число
        int j = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > j)
                j = array[i];

        }
        System.out.println("\n" + "Наибольшее число " + j);

        //сумма массива
        int sum = 0;
        for (int i = 0; i <array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println(sum);



        for (int i = array.length-1; i >=0; i--) {
            System.out.print(array[i] + " ");
        }
        */

        int[][] array = new int[3][4];
        Scanner scr = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scr.nextInt();
            }
        }

         //вывод суммы строк
            for (int i = 0; i < array.length; i++) {

            int sum = 0; // сумма для текущей строки

            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
                sum += array[i][j]; // накапливаем сумму
            }

            System.out.println("Line " + i + " = " + sum);
        }

        //вывод суммы столбцов
            for (int j = 0; j < array[0].length; j++) {

            int sum = 0; // сумма для текущей строки

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i][j] + " ");
                sum += array[i][j]; // накапливаем сумму
            }

            System.out.println("Column " + j + " = " + sum);
        }

        // замена четных и нечетных

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {


                if (array[i][j] % 2 == 0) {
                    array[i][j] = 0;

                }
                else if (array[i][j] % 2 != 0){
                    array[i][j] = 1;

                }
                System.out.print(array[i][j] + " ");
            }

            System.out.println();
        }

        // сред.ариф
        for (int i = 0; i < array.length; i++) {

            int sum = 0;
            int count = 0;
            double sr = 0;// сумма для текущей строки

            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
                sum = sum + array[i][j];
                count ++;
                // накапливаем сумму
            }
            sr = (double) sum / count;
            System.out.println("Line " + i + " = " + sr);
        }











        }

    }
