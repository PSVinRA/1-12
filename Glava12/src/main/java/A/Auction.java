package A;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
//Романов Альберт Б762-2 Вариант 9
public class Auction {
    private final Queue<Lot> lotsQueue;
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final List<Participant> participants;
    private final Map<Participant, Integer> bans = new ConcurrentHashMap<>();

    public Auction(List<Lot> lots, List<Participant> participants) {
        this.lotsQueue = new ConcurrentLinkedQueue<>(lots);
        this.participants = new CopyOnWriteArrayList<>(participants);
    }

    public void startAuction() {
        while (!lotsQueue.isEmpty()) {
            Lot currentLot = lotsQueue.poll();
            if (currentLot == null) continue;

            System.out.println("Начинаем аукцион по лоту: " + currentLot.getName());
            AtomicInteger highestBid = new AtomicInteger(currentLot.getStartingPrice());
            final Participant[] winner = {null};

            CountDownLatch latch = new CountDownLatch(participants.size());

            participants.forEach(participant -> executorService.submit(() -> {
                try {
                    if (bans.getOrDefault(participant, 0) > 0) {
                        bans.put(participant, bans.get(participant) - 1);
                        return;
                    }
                    int bid = participant.makeBid(currentLot, highestBid.get());
                    if (bid > highestBid.get()) {
                        highestBid.set(bid);
                        winner[0] = participant;
                    }
                } finally {
                    latch.countDown();
                }
            }));

            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (winner[0] != null) {
                System.out.println("Выиграла " + currentLot.getName() + ": " + winner[0].getName() + " с предложением " + highestBid.get());
                boolean paymentSuccessful = winner[0].pay(highestBid.get());
                if (!paymentSuccessful) {
                    bans.put(winner[0], 3); // Ban for 3 lots
                    System.out.println(winner[0].getName() + " не оплатил и заблокирован на 3 лота.");
                }
            } else {
                System.out.println("Нет заявок на " + currentLot.getName());
            }
        }
        executorService.shutdown();
    }
}
