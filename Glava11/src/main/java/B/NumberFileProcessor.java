package B;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class NumberFileProcessor {
    public static List<Integer> processFile(String filePath) throws IOException {
        List<Integer> c1 = new ArrayList<>();
        List<Integer> c2 = new ArrayList<>();
        boolean isFirstList = true;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String token : line.split("\\s+")) {
                    int number = Integer.parseInt(token);
                    if (number < 0) {
                        isFirstList = false;
                        continue;
                    }
                    if (isFirstList) {
                        c1.add(number);
                    } else {
                        c2.add(number);
                    }
                }
            }
        }

        Collections.sort(c1);
        Collections.sort(c2);

        c1.addAll(c2);
        return c1;
    }
}

