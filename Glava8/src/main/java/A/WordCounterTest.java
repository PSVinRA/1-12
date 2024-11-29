package A;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Романов Альберт Б762-2 Вариант 9
public class WordCounterTest {

    @Test
    public void testCountWordOccurrences() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");
        Files.writeString(tempFile, "Hello world! Hello, Java. Java is fun. Java is powerful.");

        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> result = wordCounter.countWordOccurrences(tempFile.toString());

        assertEquals(2, result.get("hello"));
        assertEquals(3, result.get("java"));
        assertEquals(2, result.get("is"));
        assertEquals(1, result.get("fun"));
        assertEquals(1, result.get("powerful"));

        Files.delete(tempFile);
    }
}
