package C;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
//Романов Альберт Б762-2 Вариант 9
public class TextFormatterTest {

    @Test
    public void testFormatText_Basic() {
        TextFormatter formatter = new TextFormatter();
        String text = "В Древней Греции было много выдающихся военачальников.";
        int maxLineLength = 10;

        List<String> result = formatter.formatText(text, maxLineLength);

        assertEquals(5, result.size());
        assertEquals("В Древней", result.get(0));
        assertEquals("Греции", result.get(1));
        assertEquals("было много", result.get(2));
        assertEquals("выдающихся", result.get(3));
        assertEquals("военачальников.", result.get(4));
    }

    @Test
    public void testFormatText_LongWord() {
        TextFormatter formatter = new TextFormatter();
        String text = "Я говорю всемприветкакдела.";
        int maxLineLength = 10;

        List<String> result = formatter.formatText(text, maxLineLength);

        assertEquals(2, result.size());
        assertEquals("Я говорю", result.get(0));
        assertEquals("всемприветкакдела.", result.get(1));
    }

    @Test
    public void testFormatText_EmptyText() {
        TextFormatter formatter = new TextFormatter();
        String text = "";
        int maxLineLength = 10;

        List<String> result = formatter.formatText(text, maxLineLength);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testFormatText_ZeroMaxLineLength() {
        TextFormatter formatter = new TextFormatter();
        String text = "Всем привет!";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatText(text, 0);
        });

        assertEquals("Максимальная длина строки должна быть больше нуля.", exception.getMessage());
    }
}
