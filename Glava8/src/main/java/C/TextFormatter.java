package C;
import java.util.ArrayList;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class TextFormatter {

    public List<String> formatText(String text, int maxLineLength) {
        if (maxLineLength <= 0) {
            throw new IllegalArgumentException("Максимальная длина строки должна быть больше нуля.");
        }

        List<String> result = new ArrayList<>();
        String[] words = text.split("\\s+");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() > maxLineLength) {
                result.add(currentLine.toString().trim());
                currentLine.setLength(0);
            }
            currentLine.append(word).append(" ");
        }

        if (currentLine.length() > 0) {
            result.add(currentLine.toString().trim());
        }

        return result;
    }
}

