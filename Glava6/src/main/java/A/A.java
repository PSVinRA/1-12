package A;
import java.util.ArrayList;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
interface Aircraft {
    void performInspection();
    void repair();
    void makeFlight();
    void refuel();
    String getInfo();
    void updateInfo(String newInfo);
}

abstract class BaseAircraft implements Aircraft {
    protected String model;
    protected int capacity;
    protected double fuelLevel;
    protected String condition;
    protected String additionalInfo;

    public BaseAircraft(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
        this.fuelLevel = 100;
        this.condition = "Исправен";
        this.additionalInfo = "Новая информация не указана";
    }

    @Override
    public void performInspection() {
        System.out.println("Техосмотр самолета \"" + model + "\" выполнен. Состояние: " + condition);
    }

    @Override
    public void repair() {
        if (!condition.equals("Исправен")) {
            condition = "Исправен";
            System.out.println("Самолет \"" + model + "\" отремонтирован.");
        } else {
            System.out.println("Самолет \"" + model + "\" не нуждается в ремонте.");
        }
    }

    @Override
    public void makeFlight() {
        if (fuelLevel < 30) {
            System.out.println("Недостаточно топлива для рейса. Заправьте самолет \"" + model + "\".");
        } else if (!condition.equals("Исправен")) {
            System.out.println("Самолет \"" + model + "\" нуждается в ремонте перед рейсом.");
        } else {
            fuelLevel -= 30;
            System.out.println("Самолет \"" + model + "\" успешно совершил рейс. Оставшийся уровень топлива: " + fuelLevel + "%.");
        }
    }

    @Override
    public void refuel() {
        fuelLevel = 100;
        System.out.println("Самолет \"" + model + "\" полностью заправлен.");
    }

    @Override
    public String getInfo() {
        return "Модель: " + model +
                ", Вместимость: " + capacity +
                ", Уровень топлива: " + fuelLevel +
                "%, Состояние: " + condition +
                ", Дополнительная информация: " + additionalInfo;
    }

    @Override
    public void updateInfo(String newInfo) {
        additionalInfo = newInfo;
        System.out.println("Информация о самолете \"" + model + "\" обновлена.");
    }
}

class CivilAircraft extends BaseAircraft {
    private boolean hasInFlightEntertainment;

    public CivilAircraft(String model, int capacity, boolean hasInFlightEntertainment) {
        super(model, capacity);
        this.hasInFlightEntertainment = hasInFlightEntertainment;
    }

    public void enableEntertainmentSystem() {
        if (hasInFlightEntertainment) {
            System.out.println("Система развлечений в самолете \"" + model + "\" включена.");
        } else {
            System.out.println("Самолет \"" + model + "\" не оснащен системой развлечений.");
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Развлечения: " + (hasInFlightEntertainment ? "Да" : "Нет");
    }
}

class MilitaryAircraft extends BaseAircraft {
    private int ammunitionLevel;

    public MilitaryAircraft(String model, int capacity, int ammunitionLevel) {
        super(model, capacity);
        this.ammunitionLevel = ammunitionLevel;
    }

    public void reloadWeapons() {
        ammunitionLevel = 100;
        System.out.println("Оружие самолета \"" + model + "\" полностью перезаряжено.");
    }

    public void performCombatMission() {
        if (ammunitionLevel < 20) {
            System.out.println("Недостаточно боезапаса для выполнения боевой задачи. Перезарядите самолет \"" + model + "\".");
        } else if (!condition.equals("Исправен")) {
            System.out.println("Самолет \"" + model + "\" нуждается в ремонте перед выполнением боевой задачи.");
        } else {
            ammunitionLevel -= 20;
            fuelLevel -= 40;
            System.out.println("Самолет \"" + model + "\" успешно выполнил боевую задачу. Оставшийся боезапас: " + ammunitionLevel + "%, топливо: " + fuelLevel + "%.");
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Боезапас: " + ammunitionLevel + "%";
    }
}

class Airline {
    private List<Aircraft> fleet;

    public Airline() {
        this.fleet = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        fleet.add(aircraft);
        System.out.println("Самолет добавлен в авиакомпанию.");
    }

    public void showFleetInfo() {
        System.out.println("Информация о флоте авиакомпании:");
        for (Aircraft aircraft : fleet) {
            System.out.println(aircraft.getInfo());
        }
    }
}

public class A {
    public static void main(String[] args) {
        Airline airline = new Airline();

        CivilAircraft civil1 = new CivilAircraft("Boeing 737", 180, true);
        CivilAircraft civil2 = new CivilAircraft("Airbus A320", 150, false);
        MilitaryAircraft military1 = new MilitaryAircraft("F-16", 2, 80);
        MilitaryAircraft military2 = new MilitaryAircraft("SU-35", 1, 100);

        airline.addAircraft(civil1);
        airline.addAircraft(civil2);
        airline.addAircraft(military1);
        airline.addAircraft(military2);

        airline.showFleetInfo();

        civil1.performInspection();
        civil1.enableEntertainmentSystem();
        civil1.makeFlight();
        civil1.refuel();

        military1.performCombatMission();
        military1.reloadWeapons();
        military1.makeFlight();
        military1.repair();
    }
}

