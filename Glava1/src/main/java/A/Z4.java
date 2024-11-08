package A;
import java.util.Scanner;

public class Z4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        String samplePassword = "123";
        boolean isCorrect = password.equals(samplePassword);

        if (isCorrect) {
            System.out.println("Пароль верный.");
        } else {
            System.out.println("Пароль неверный.");
        }
    }
}
