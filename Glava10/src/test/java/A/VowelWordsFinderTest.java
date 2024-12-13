package A;
import A.VowelWordsFinder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
import static org.junit.jupiter.api.Assertions.*;

public class VowelWordsFinderTest {

    @Test
    public void testFindVowelWords() throws IOException {
        String filePath = "src/test/java/resources/vowel_words_test.txt";
        Files.writeString(Path.of(filePath), "Яблоко арбуз");

        List<String> result = VowelWordsFinder.findVowelWords(filePath);

        assertEquals(List.of("Яблоко", "арбуз"), result);
    }
}

