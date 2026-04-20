package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class GradeAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к папке с файлами оценок: ");
        String folderPath = scanner.nextLine();

        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            System.out.println("Это не папка.");
            return;
        }

        File reportFile = new File(folder, "отчет.txt");
        try {
            if (reportFile.exists()) {
                new PrintWriter(reportFile).close();
            }
        } catch (Exception e) {
            System.out.println("Ошибка при очистке файла отчета: " + e.getMessage());
            return;
        }


        Map<String, List<Integer>> subjectGrades = new HashMap<>();
        Map<String, Double> studentAverages = new HashMap<>();

        Pattern fioPattern = Pattern.compile("^[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+$");
        Pattern linePattern = Pattern.compile("^(.+)\\s-\\s([1-5])$");

        int validStudents = 0;

        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (!file.isFile() || file.getName().equals("отчет.txt")) continue;

            String fio = file.getName().replace(".txt", "");
            if (!fioPattern.matcher(fio).matches()) {
                System.out.println("Файл \"" + file.getName() + "\" имеет неверное название (не ФИО).");
                continue;
            }

            Map<String, Integer> grades = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher m = linePattern.matcher(line.trim());
                    if (m.matches()) {
                        grades.put(m.group(1).trim(), Integer.parseInt(m.group(2)));
                    } else {
                        System.out.println("В файле \"" + file.getName() + "\" строка \"" + line + "\" некорректна.");
                        grades.clear();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла \"" + file.getName() + "\": " + e.getMessage());
                continue;
            }

            if (grades.size() < 5) {
                System.out.println("В файле \"" + file.getName() + "\" меньше 5 предметов.");
                continue;
            }


            for (Map.Entry<String, Integer> entry : grades.entrySet()) {
                subjectGrades.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(entry.getValue());
            }

            double avg = grades.values().stream().mapToInt(i -> i).average().orElse(0);
            studentAverages.put(fio, avg);
            validStudents++;
        }


        StringBuilder report = new StringBuilder();

        if (validStudents == 0) {
            report.append("Не найдено корректных файлов.\n");
        } else {
            report.append("Средний балл по предметам:\n");
            for (Map.Entry<String, List<Integer>> entry : subjectGrades.entrySet()) {
                double avg = entry.getValue().stream().mapToInt(i -> i).average().orElse(0);
                report.append(String.format("%s - %.2f%n", entry.getKey(), avg));
            }


            var best = studentAverages.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
            var worst = studentAverages.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);

            if (best != null) {
                report.append("\nЛучший ученик:\n").append(String.format("%s (%.2f)%n", best.getKey(), best.getValue()));
            }
            if (worst != null) {
                report.append("\nХудший ученик:\n").append(String.format("%s (%.2f)%n", worst.getKey(), worst.getValue()));
            }

            report.append("\nКоличество учеников: ").append(validStudents).append("\n");
        }


        System.out.println(report);


        try (PrintWriter out = new PrintWriter(new FileWriter(reportFile))) {
            out.print(report);
        } catch (IOException e) {
            System.out.println("Ошибка записи отчета: " + e.getMessage());
        }
    }
}
