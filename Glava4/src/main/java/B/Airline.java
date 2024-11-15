package B;
//Романов Альберт Б762-2 Вариант 9
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airline {
    private List<Aircraft> fleet;

    public Airline() {
        fleet = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        fleet.add(aircraft);
    }

    public double calculateTotalPassengerCapacity() {
        return fleet.stream()
                .filter(a -> a instanceof PassengerAircraft)
                .mapToDouble(a -> ((PassengerAircraft) a).getPassengerCapacity())
                .sum();
    }

    public double calculateTotalCargoCapacity() {
        return fleet.stream()
                .filter(a -> a instanceof CargoAircraft)
                .mapToDouble(a -> ((CargoAircraft) a).getCargoCapacity())
                .sum();
    }

    public List<Aircraft> sortByRange() {
        return fleet.stream()
                .sorted(Comparator.comparingDouble(Aircraft::getRange))
                .collect(Collectors.toList());
    }

    public List<Aircraft> findAircraftByFuelConsumption(double minFuel, double maxFuel) {
        return fleet.stream()
                .filter(a -> a.getFuelConsumption() >= minFuel && a.getFuelConsumption() <= maxFuel)
                .collect(Collectors.toList());
    }

    public List<Aircraft> getFleet() {
        return fleet;
    }
}
