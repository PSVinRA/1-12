package A;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
//Романов Альберт Б762-2 Вариант 9
public class WordCounter {

    public Map<String, Integer> countWordOccurrences(String filePath) throws IOException {
        String content = Files.readString(Paths.get(filePath)).toLowerCase();
        String[] words = content.split("\\W+");

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        return wordCounts;
    }
}

