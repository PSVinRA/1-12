package A;

public class Z5 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не переданы аргументы.");
            return;
        }

        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }

        int sum = 0;
        int product = 1;
        for (int number : numbers) {
            sum += number;
            product *= number;
        }

        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
    }
}

