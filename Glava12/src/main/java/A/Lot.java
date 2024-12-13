package A;
//Романов Альберт Б762-2 Вариант 9
public class Lot {
    private final String name;
    private final int startingPrice;

    public Lot(String name, int startingPrice) {
        this.name = name;
        this.startingPrice = startingPrice;
    }

    public String getName() {
        return name;
    }

    public int getStartingPrice() {
        return startingPrice;
    }
}

