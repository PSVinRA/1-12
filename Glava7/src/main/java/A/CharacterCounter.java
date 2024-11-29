package A;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
//Романов Альберт Б762-2 Вариант 9
public class CharacterCounter {
    public Map<Character, Integer> countCharacterOccurrences(String filePath) throws IOException {
        String content = Files.readString(Path.of(filePath));
        Map<Character, Integer> characterCount = new HashMap<>();

        for (char c : content.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        return characterCount;
    }
}



