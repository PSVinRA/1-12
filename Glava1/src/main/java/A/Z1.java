package A;
import java.util.Scanner;

public class Z1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();

        System.out.println("Привет, " + name + "!");
    }
}
