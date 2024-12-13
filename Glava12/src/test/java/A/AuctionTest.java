package A;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
class AuctionTest {
    @Test
    void testAuction() {
        List<Lot> lots = Arrays.asList(
                new Lot("Антикварная ваза", 100),
                new Lot("Рисование", 200),
                new Lot("Скульптура", 300)
        );

        List<Participant> participants = Arrays.asList(
                new Participant("Алиса", 500),
                new Participant("Боб", 400),
                new Participant("Альберт", 600)
        );

        Auction auction = new Auction(lots, participants);
        auction.startAuction();
    }
}
