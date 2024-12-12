package A;
import A.NumberProcessor;
import A.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
import static org.junit.jupiter.api.Assertions.*;

public class NumberProcessorTest {

    @Test
    public void testProcessFile_ValidInput() throws IOException, InvalidNumberException {
        String filePath = "src/test/java/A/resources/valid_numbers.txt";
        List<Double> numbers = NumberProcessor.processFile(filePath);

        assertEquals(Arrays.asList(1234.56, 7890.12, 3456.78), numbers);
    }

    @Test
    public void testProcessFile_InvalidFormat() {
        String filePath = "src/test/java/A/resources/invalid_format.txt";

        assertThrows(InvalidNumberException.class, () -> NumberProcessor.processFile(filePath));
    }

    @Test
    public void testCalculateSum() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        assertEquals(10.0, NumberProcessor.calculateSum(numbers));
    }

    @Test
    public void testCalculateAverage() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        assertEquals(2.5, NumberProcessor.calculateAverage(numbers));
    }

    @Test
    public void testCalculateAverage_EmptyList() {
        List<Double> numbers = Arrays.asList();
        assertEquals(0.0, NumberProcessor.calculateAverage(numbers));
    }
}

