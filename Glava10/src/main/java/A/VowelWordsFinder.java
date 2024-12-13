package A;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class VowelWordsFinder {

    public static List<String> findVowelWords(String filePath) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (isVowel(word.charAt(0))) {
                        result.add(word);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiouАЕИОУЭЮЯаеиоуэюя".indexOf(c) != -1;
    }
}

