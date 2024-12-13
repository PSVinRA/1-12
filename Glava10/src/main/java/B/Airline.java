package B;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class Airline implements Serializable {
    private List<Airplane> airplanes = new ArrayList<>();

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public double getTotalCapacity() {
        return airplanes.stream().mapToDouble(Airplane::getCapacity).sum();
    }

    public double getTotalCargoCapacity() {
        return airplanes.stream().mapToDouble(Airplane::getCargoCapacity).sum();
    }

    public List<Airplane> sortByRange() {
        airplanes.sort(Comparator.comparingDouble(Airplane::getRange));
        return airplanes;
    }

    public List<Airplane> findByFuelRange(double minFuel, double maxFuel) {
        List<Airplane> result = new ArrayList<>();
        for (Airplane airplane : airplanes) {
            if (airplane.getFuelConsumption() >= minFuel && airplane.getFuelConsumption() <= maxFuel) {
                result.add(airplane);
            }
        }
        return result;
    }
}