package A;
import java.util.Random;

public class Z3 {

    public static void main(String[] args) {
        Random random = new Random();
        int count = 3;
        System.out.println("С переходом: ");
        for (int i = 0; i < count; i++) {
            System.out.println(random.nextInt(100));
        }
        System.out.print("Без перехода: ");
        for (int i = 0; i < count; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
    }
}
