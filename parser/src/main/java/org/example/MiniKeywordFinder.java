package org.example;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class MiniKeywordFinder {  //что делает это?
    public static void main(String[] args) throws IOException {//что делает это?
        if (args.length < 2) {//что делает это?
            System.out.println("Использование: java MiniKeywordFinder <файл> \"слово1,слово2\"");//что делает это?
            return;//что делает это?
        }//что делает это?

        Path file = Paths.get(args[0]);//что делает это?
        String[] words = args[1].split(",");//что делает это?

        // готовим шаблоны поиска (игнорируем регистр)
        List<Pattern> patterns = new ArrayList<>();//что делает это?
        for (String w : words) {//что делает это?
            String kw = w.trim();//что делает это?
            if (!kw.isEmpty()) {//что делает это?
                Pattern p = Pattern.compile(Pattern.quote(kw),//что делает это?
                        Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);//что делает это?
                patterns.add(p);//что делает это?
            }
        }

        List<String> lines = Files.readAllLines(file);//что делает это?
        int lineNo = 0;//что делает это?
        for (String line : lines) {//что делает это?
            lineNo++;//что делает это?
            boolean hit = false;//что делает это?
            for (Pattern p : patterns) {//что делает это?
                if (p.matcher(line).find()) {//что делает это?
                    hit = true;//что делает это?
                    break;//что делает это?
                }
            }
            if (hit) {//что делает это?
                System.out.printf("%5d | %s%n", lineNo, line);//что делает это?
            }
        }
    }
}