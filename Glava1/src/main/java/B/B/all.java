package B.B;

import java.util.*;

public class all {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество целых чисел:");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Введите целые числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 1. Четные и нечетные числа
        System.out.println("Четные числа:");
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        System.out.println("Нечетные числа:");
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        // 2. Наибольшее и наименьшее число
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        System.out.println("Наибольшее число: " + max);
        System.out.println("Наименьшее число: " + min);

        // 3. Числа, которые делятся на 3 или на 9
        System.out.println("Числа, которые делятся на 3 или на 9:");
        for (int number : numbers) {
            if (number % 3 == 0 || number % 9 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        // 4. Числа, которые делятся на 5 и на 7
        System.out.println("Числа, которые делятся на 5 и на 7:");
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        // 5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр
        System.out.println("Все трехзначные числа, в десятичной записи которых нет одинаковых цифр:");
        for (int number : numbers) {
            if (number >= 100 && number <= 999) {
                int[] digits = new int[3];
                digits[0] = number / 100;
                digits[1] = (number % 100) / 10;
                digits[2] = number % 10;
                if (digits[0] != digits[1] && digits[0] != digits[2] && digits[1] != digits[2]) {
                    System.out.print(number + " ");
                }
            }
        }
        System.out.println();

        // 6. Простые числа
        System.out.println("Простые числа:");
        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        // 7. Отсортированные числа в порядке возрастания и убывания
        System.out.println("Отсортированные числа в порядке возрастания:");
        Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.println("Отсортированные числа в порядке убывания:");
        Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 8. Числа в порядке убывания частоты встречаемости чисел
        System.out.println("Числа в порядке убывания частоты встречаемости чисел:");
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        for (Map.Entry<Integer, Integer> entry : frequencyList) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();

        // 9. «Счастливые» числа
        System.out.println("«Счастливые» числа:");
        for (int number : numbers) {
            if (isHappy(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        // 10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают
        System.out.println("Числа-палиндромы:");
        for (int number : numbers) {
            if (isPalindrome(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        // 11. Элементы, которые равны полусумме соседних элементов
        System.out.println("Элементы, которые равны полусумме соседних элементов:");
        for (int i = 1; i < n - 1; i++) {
            if (numbers[i] == (numbers[i - 1] + numbers[i + 1]) / 2) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isHappy(int number) {
        Set<Integer> seenNumbers = new HashSet<>();
        while (number != 1) {
            int sum = 0;
            while (number > 0) {
                int digit = number % 10;
                sum += digit * digit;
                number /= 10;
            }
            number = sum;
            if (seenNumbers.contains(number)) {
                return false;
            }
            seenNumbers.add(number);
        }
        return true;
    }

    private static boolean isPalindrome(int number) {
        int reversedNumber = 0;
        int originalNumber = number;
        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return originalNumber == reversedNumber;
    }
}

