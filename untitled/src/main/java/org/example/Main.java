package org.example;

public class Main {
    public static void main(String[] args) {
        String name = "Никита 14";
        method(name);

    }

    public static void method(String name) {
        String[] strArray = name.split(" ");
        int num = Integer.parseInt(strArray[1]);
        int result = 0;
        int chislo = 0;
        if (num < 10 || num > 99999) {
            System.out.println("Ошибка число должно иметь от 2 до 5 разрядов");

        } else {
            while (num > 0) {
                chislo = num % 10;

                result += chislo;
                num = num / 10;
            }
            switch (result) {
                case 1:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Один");
                    break;
                case 2:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Два");
                    break;
                case 3:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Три");
                    break;
                case 4:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Четыре");
                    break;
                case 5:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Пять");
                    break;
                case 6:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Шесть");
                    break;
                case 7:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Семь");
                    break;
                case 8:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Восемь");
                    break;
                case 9:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Девять");
                    break;
                case 10:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + "Десять");
                    break;
                default:
                    System.out.println("Здравствуй " + strArray[0] + "! Сумма цифр в числе = " + result);
            }

        }
    }
}