package A;

public class Z2 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не переданы аргументы.");
            return;
        }

        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}

