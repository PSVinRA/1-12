package B;
//Романов Альберт Б762-2 Вариант 9
public abstract class Aircraft {
    private String model;
    private double range;
    private double fuelConsumption;

    public Aircraft(String model, double range, double fuelConsumption) {
        this.model = model;
        this.range = range;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public double getRange() {
        return range;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("Модель: %s, Дальность: %.2f км, Потребление топлива: %.2f л/час", model, range, fuelConsumption);
    }
}

