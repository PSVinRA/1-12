package B;
import java.util.*;
import java.util.stream.Collectors;
//Романов Альберт Б762-2 Вариант 9
public class TextProcessor {

    public static class Word {
        private final String value;

        public Word(String value) {
            this.value = value.trim();
        }

        public String getValue() {
            return value;
        }

        public int countOccurrences(char letter) {
            return (int) value.chars().filter(c -> c == letter).count();
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public List<Word> parseWords(String text) {
        text = text.replaceAll("\\s+", " ");
        String[] wordsArray = text.split("[\\s,.!?;:\"()]+");
        List<Word> words = new ArrayList<>();
        for (String word : wordsArray) {
            if (!word.isEmpty()) {
                words.add(new Word(word));
            }
        }
        return words;
    }

    public List<Word> sortWordsByLetterCount(List<Word> words, char letter) {
        return words.stream()
                .sorted(Comparator.comparingInt((Word w) -> w.countOccurrences(letter))
                        .thenComparing(Word::getValue))
                .collect(Collectors.toList());
    }
}
