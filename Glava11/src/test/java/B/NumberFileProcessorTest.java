package B;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Романов Альберт Б762-2 Вариант 9
class NumberFileProcessorTest {
    @Test
    void testProcessFile() throws IOException {
        String filePath = "testfile.txt";
        String fileContent = "3 5 7 -1 2 4 6";
        Files.writeString(Path.of(filePath), fileContent);

        List<Integer> expected = Arrays.asList(3, 5, 7, 2, 4, 6);
        List<Integer> result = NumberFileProcessor.processFile(filePath);
        assertEquals(expected, result);

        Files.delete(Path.of(filePath));
    }
}
