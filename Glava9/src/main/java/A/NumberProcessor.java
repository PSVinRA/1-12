package A;
import A.exception.InvalidNumberException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
//Романов Альберт Б762-2 Вариант 9
public class NumberProcessor {

    public static List<Double> processFile(String filePath) throws IOException, InvalidNumberException {
        List<Double> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 2) {
                    throw new InvalidNumberException("Недопустимый формат строки: " + line);
                }

                String numberString = parts[0].trim();
                String localeString = parts[1].trim();

                try {
                    Locale locale = Locale.forLanguageTag(localeString);
                    NumberFormat format = NumberFormat.getInstance(locale);
                    Number number = format.parse(numberString);

                    if (number.doubleValue() > Double.MAX_VALUE) {
                        throw new InvalidNumberException("Число превышает максимальное значение: " + number);
                    }

                    numbers.add(number.doubleValue());
                } catch (ParseException e) {
                    throw new InvalidNumberException("Не удалось разобрать номер: " + numberString);
                }
            }
        } catch (OutOfMemoryError e) {
            throw new IOException("Не хватает памяти при обработке файла.", e);
        }

        return numbers;
    }

    public static double calculateSum(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    public static double calculateAverage(List<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return calculateSum(numbers) / numbers.size();
    }
}
