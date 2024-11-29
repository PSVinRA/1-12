package C;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class Main {
    public static void main(String[] args) {
        TextFormatter formatter = new TextFormatter();
        String text = "В Древней Греции было много выдающихся военачальников, которые оставили заметный след в истории.";
        int maxLineLength = 20;

        List<String> formattedText = formatter.formatText(text, maxLineLength);

        System.out.println("Форматирование текста по левому краю:");
        formattedText.forEach(System.out::println);
    }
}

