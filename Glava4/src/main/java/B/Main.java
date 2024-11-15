package B;
//Романов Альберт Б762-2 Вариант 9
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Airline airline = new Airline();
        initializeFleet(airline);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показать все самолёты");
            System.out.println("2. Общая вместимость и грузоподъёмность");
            System.out.println("3. Сортировка по дальности полёта");
            System.out.println("4. Поиск по потреблению топлива");
            System.out.println("5. Выход");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    airline.getFleet().forEach(System.out::println);
                    break;
                case 2:
                    System.out.printf("Общая пассажирская вместимость: %.0f\n", airline.calculateTotalPassengerCapacity());
                    System.out.printf("Общая грузоподъёмность: %.2f тонн\n", airline.calculateTotalCargoCapacity());
                    break;
                case 3:
                    List<Aircraft> sortedFleet = airline.sortByRange();
                    sortedFleet.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Введите минимальное потребление топлива: ");
                    double minFuel = scanner.nextDouble();
                    System.out.print("Введите максимальное потребление топлива: ");
                    double maxFuel = scanner.nextDouble();
                    List<Aircraft> filteredFleet = airline.findAircraftByFuelConsumption(minFuel, maxFuel);
                    if (filteredFleet.isEmpty()) {
                        System.out.println("Нет самолётов с такими параметрами.");
                    } else {
                        filteredFleet.forEach(System.out::println);
                    }
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private static void initializeFleet(Airline airline) {
        airline.addAircraft(new PassengerAircraft("Boeing 737", 3500, 2.5, 180));
        airline.addAircraft(new PassengerAircraft("Airbus A320", 3200, 2.7, 160));
        airline.addAircraft(new CargoAircraft("C-130 Hercules", 2000, 4.5, 20));
        airline.addAircraft(new CargoAircraft("Antonov An-124", 4800, 8.0, 120));
        airline.addAircraft(new PassengerAircraft("Boeing 747", 9800, 10.0, 400));
    }
}
