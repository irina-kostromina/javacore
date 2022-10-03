import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class App {

    public static void main(String[] args) {
        String[] words = {
                "голова",
                "рука",
                "нога",
                "палец",
                "голова",
                "палец",
                "голова",
                "локоть",
                "голова",
                "кость",
                "колено",
                "голова",
                "нога",
                "палец",
        };

        HashSet<String> setWords = new HashSet<>(Arrays.asList(words));
        HashMap<String, Integer> wordsCount = new HashMap<>();

        for (String word : words) {
            if (wordsCount.containsKey(word)) {
                Integer count = wordsCount.get(word);
                wordsCount.put(word, count + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }

        System.out.println("Вывод уникальных слов:");
        for (String uniq: setWords) {
            System.out.println(uniq);
        }
        System.out.println();

        System.out.println("Подсчет слов:");
        for (String word: wordsCount.keySet()) {
            Integer count = wordsCount.get(word);
            System.out.println(word + ": " + count);
        }
    }
}
