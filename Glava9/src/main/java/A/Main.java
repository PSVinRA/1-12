package A;
import A.exception.InvalidNumberException;
import java.io.IOException;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/A/resources/valid_numbers.txt";

        try {
            List<Double> numbers = NumberProcessor.processFile(filePath);
            double sum = NumberProcessor.calculateSum(numbers);
            double average = NumberProcessor.calculateAverage(numbers);

            System.out.println("Числа: " + numbers);
            System.out.println("Сумма: " + sum);
            System.out.println("Средняя величина: " + average);
        } catch (IOException | InvalidNumberException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
