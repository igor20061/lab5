package lab5.zad5;

import java.io.*;
import java.util.*;

public class ConsonantFinder {

    private static final String VOICED = "бвгджзлмнрй";

    public static List<String> find(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder textBuilder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            textBuilder.append(line).append(" ");
        }
        reader.close();

        String text = textBuilder.toString().toLowerCase().replace('ё', 'е');
        String[] words = text.split("[^а-я]+");

        // Считаем в скольких словах встречается каждая согласная
        Map<Character, Integer> counter = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            Set<Character> found = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (VOICED.indexOf(c) != -1) {
                    found.add(c);
                }
            }

            for (char c : found) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }
        }

        // Отбираем согласные, которые встречаются более чем в одном слове
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(String.valueOf(entry.getKey()));
            }
        }

        Collections.sort(result);
        return result;
    }
}