package B;
//Романов Альберт Б762-2 Вариант 9
public class PassengerAircraft extends Aircraft {
    private int passengerCapacity;

    public PassengerAircraft(String model, double range, double fuelConsumption, int passengerCapacity) {
        super(model, range, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Вместимость: %d пассажиров", passengerCapacity);
    }
}
