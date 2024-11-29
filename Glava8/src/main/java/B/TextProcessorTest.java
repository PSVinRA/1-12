package B;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Романов Альберт Б762-2 Вариант 9
public class TextProcessorTest {

    @Test
    public void testParseWords() {
        String text = "Квантовая механика также описывает квантовые переходы";
        TextProcessor processor = new TextProcessor();
        List<TextProcessor.Word> words = processor.parseWords(text);

        assertEquals(6, words.size());
        assertEquals("Квантовая", words.get(0).getValue());
        assertEquals("механика", words.get(1).getValue());
        assertEquals("также", words.get(2).getValue());
        assertEquals("описывает", words.get(3).getValue());
        assertEquals("квантовые", words.get(4).getValue());
        assertEquals("переходы", words.get(5).getValue());
    }

    @Test
    public void testSortWordsByLetterCount() {
        String text = "Квантовая механика также описывает квантовые переходы";
        TextProcessor processor = new TextProcessor();
        List<TextProcessor.Word> words = processor.parseWords(text);

        char letterToCount = 'е';
        List<TextProcessor.Word> sortedWords = processor.sortWordsByLetterCount(words, letterToCount);

        assertEquals("Квантовая", sortedWords.get(0).getValue());
        assertEquals("квантовые", sortedWords.get(1).getValue());
        assertEquals("механика", sortedWords.get(2).getValue());
        assertEquals("описывает", sortedWords.get(3).getValue());
        assertEquals("также", sortedWords.get(4).getValue());
        assertEquals("переходы", sortedWords.get(5).getValue());

    }
}
