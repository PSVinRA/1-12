package B;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
//Романов Альберт Б762-2 Вариант 9
public class AirlineTest {

    @Test
    public void testAirlineOperations() throws IOException, ClassNotFoundException {
        Airline airline = new Airline();
        airline.addAirplane(new Airplane("Боинг 747", 15000, 300, 20000, 3.5));
        airline.addAirplane(new Airplane("Аэробус A320", 12000, 200, 15000, 2.5));

        assertEquals(500, airline.getTotalCapacity());
        assertEquals(35000, airline.getTotalCargoCapacity());

        List<Airplane> sorted = airline.sortByRange();
        assertEquals("Аэробус A320", sorted.get(0).getModel());

        List<Airplane> fuelRange = airline.findByFuelRange(2, 3);
        assertEquals(1, fuelRange.size());
        assertEquals("Аэробус A320", fuelRange.get(0).getModel());
    }

    @Test
    public void testSaveAndLoad() throws IOException, ClassNotFoundException {
        Airline airline = new Airline();
        airline.addAirplane(new Airplane("Боинг 747", 15000, 300, 20000, 3.5));
        airline.addAirplane(new Airplane("Аэробус A320", 12000, 200, 15000, 2.5));

        String filePath = "airline.dat";
        airline.saveToFile(filePath);

        Airline loadedAirline = Airline.loadFromFile(filePath);

        assertEquals(2, loadedAirline.sortByRange().size());
        assertEquals(500, loadedAirline.getTotalCapacity());
        assertEquals("Аэробус A320", loadedAirline.sortByRange().get(0).getModel());

        new File(filePath).delete();
    }
}
