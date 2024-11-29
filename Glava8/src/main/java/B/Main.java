package B;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class Main {
    public static void main(String[] args) {
        String text = "В классической механике мы можем точно определить положение и скорость каждого шарика в коробке.";
        TextProcessor processor = new TextProcessor();

        List<TextProcessor.Word> words = processor.parseWords(text);
        System.out.println("Оригинальный текст: " + words);

        char letterToCount = 'с';
        List<TextProcessor.Word> sortedWords = processor.sortWordsByLetterCount(words, letterToCount);

        System.out.println("Отсортированные слова по буквам '" + letterToCount + "': " + sortedWords);
    }
}
