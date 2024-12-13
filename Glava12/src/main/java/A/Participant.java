package A;
import java.util.concurrent.ThreadLocalRandom;
//Романов Альберт Б762-2 Вариант 9
public class Participant {
    private final String name;
    private final int maxBidAmount;

    public Participant(String name, int maxBidAmount) {
        this.name = name;
        this.maxBidAmount = maxBidAmount;
    }

    public String getName() {
        return name;
    }

    public int makeBid(Lot lot, int currentHighestBid) {
        int bid = ThreadLocalRandom.current().nextInt(currentHighestBid + 1, maxBidAmount + 1);
        System.out.println(name + " делает ставку на " + bid + " для лота " + lot.getName());
        return bid;
    }

    public boolean pay(int amount) {
        boolean canPay = ThreadLocalRandom.current().nextBoolean();
        if (canPay) {
            System.out.println(name + " оплачиваемый " + amount);
        }
        return canPay;
    }
}

