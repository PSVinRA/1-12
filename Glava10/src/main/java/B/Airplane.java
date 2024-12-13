package B;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class Airplane implements Serializable {
    private String model;
    private double range;
    private double capacity;
    private double cargoCapacity;
    private double fuelConsumption;

    public Airplane(String model, double range, double capacity, double cargoCapacity, double fuelConsumption) {
        this.model = model;
        this.range = range;
        this.capacity = capacity;
        this.cargoCapacity = cargoCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public double getRange() {
        return range;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}