package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class chtenit {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            Random random = new Random();
            // запись всей строки

            for(int i = 1; i <= 50; i++) {
                String randomString = generateRandomString(10, random);
                writer.write(randomString + "\n");
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("notes3.txt"))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("s")) {
                    System.out.println(line);
                    count++;
                }
            }

            System.out.println("\nНайдено " + count + " строк с буквой `s`");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static String generateRandomString(int length, Random random) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }
}
