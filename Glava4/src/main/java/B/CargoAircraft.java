package B;
//Романов Альберт Б762-2 Вариант 9
public class CargoAircraft extends Aircraft {
    private double cargoCapacity;

    public CargoAircraft(String model, double range, double fuelConsumption, double cargoCapacity) {
        super(model, range, fuelConsumption);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Грузоподъемность: %.2f тонн", cargoCapacity);
    }
}
