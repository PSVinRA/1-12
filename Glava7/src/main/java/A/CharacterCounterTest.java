package A;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//Романов Альберт Б762-2 Вариант 9
public class CharacterCounterTest {
    @Test
    public void testCountCharacterOccurrences() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");
        Files.writeString(tempFile, "ar");

        CharacterCounter counter = new CharacterCounter();
        Map<Character, Integer> result = counter.countCharacterOccurrences(tempFile.toString());

        assertEquals(1, result.get('a'));
        assertEquals(1, result.get('r'));

        Files.delete(tempFile);
    }

    @Test
    public void testEmptyFile() throws IOException {
        Path tempFile = Files.createTempFile("emptyTestFile", ".txt");
        Files.writeString(tempFile, "");

        CharacterCounter counter = new CharacterCounter();
        Map<Character, Integer> result = counter.countCharacterOccurrences(tempFile.toString());

        assertEquals(0, result.size());

        Files.delete(tempFile);
    }

    @Test
    public void testFileNotFound() {
        CharacterCounter counter = new CharacterCounter();

        assertThrows(IOException.class, () -> counter.countCharacterOccurrences("nonexistent_file.txt"));
    }
}
