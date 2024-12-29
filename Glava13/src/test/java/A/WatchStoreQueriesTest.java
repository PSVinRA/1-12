package A;
import A.DatabaseInitializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
//Романов Альберт Б762-2 Вариант 9
class WatchStoreQueriesTest {

    private static WatchStoreQueries queries;

    @BeforeAll
    static void setup() {
        try {
            DatabaseInitializer.initialize();

            Connection connection = DatabaseConnection.getInstance();

            queries = new WatchStoreQueries(connection);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Не удалось настроить базу данных и запросы.");
        }
    }

    @Test
    void testGetWatchesByType() {
        List<String> quartzWatches = queries.getWatchesByType("Quartz");
        assertTrue(quartzWatches.contains("Casio G-Shock"));
        assertTrue(quartzWatches.contains("Seiko Presage"));
    }

    @Test
    void testGetMechanicalWatchesUnderPrice() {
        List<String> mechanicalWatches = queries.getMechanicalWatchesUnderPrice(9000);
        assertTrue(mechanicalWatches.contains("Omega Seamaster"));
        assertFalse(mechanicalWatches.contains("Rolex Submariner"));
    }

    @Test
    void testGetWatchesByCountry() {
        List<String> swissWatches = queries.getWatchesByCountry("Switzerland");
        assertTrue(swissWatches.contains("Rolex Submariner"));
        assertTrue(swissWatches.contains("Omega Seamaster"));
    }

    @Test
    void testGetManufacturersByTotalValueUnder() {
        List<String> manufacturers = queries.getManufacturersByTotalValueUnder(20000);
        assertTrue(manufacturers.contains("Casio"));
        assertFalse(manufacturers.contains("Rolex"));
    }
}
