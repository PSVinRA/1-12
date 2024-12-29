package A;
import A.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        try {
            DatabaseInitializer.initialize();

            Connection connection = DatabaseConnection.getInstance();

            WatchStoreQueries queries = new WatchStoreQueries(connection);

            System.out.println("Часы кварцевого типа:");
            queries.getWatchesByType("Quartz").forEach(System.out::println);

            System.out.println("\nМеханические часы с ценой ниже 5000:");
            queries.getMechanicalWatchesUnderPrice(5000).forEach(System.out::println);

            System.out.println("\nЧасы, изготовленные в Швейцарии:");
            queries.getWatchesByCountry("Switzerland").forEach(System.out::println);

            System.out.println("\nПроизводители с общей стоимостью часов ниже 10000:");
            queries.getManufacturersByTotalValueUnder(10000).forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
