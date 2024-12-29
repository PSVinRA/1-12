package A;
import java.sql.Connection;
import java.sql.Statement;
//Романов Альберт Б762-2 Вариант 9
public class DatabaseInitializer {
    public static void initialize() {
        try (Connection conn = DatabaseConnection.getInstance();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS Manufacturer (" +
                    "id IDENTITY PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "country VARCHAR(255))");

            stmt.execute("CREATE TABLE IF NOT EXISTS Watch (" +
                    "id IDENTITY PRIMARY KEY, " +
                    "brand VARCHAR(255), " +
                    "type VARCHAR(50), " +
                    "price DECIMAL(10, 2), " +
                    "quantity INT, " +
                    "manufacturer_id INT, " +
                    "FOREIGN KEY (manufacturer_id) REFERENCES Manufacturer(id))");

            stmt.execute("INSERT INTO Manufacturer (name, country) VALUES " +
                    "('Rolex', 'Switzerland'), " +
                    "('Casio', 'Japan'), " +
                    "('Omega', 'Switzerland'), " +
                    "('Seiko', 'Japan')");

            stmt.execute("INSERT INTO Watch (brand, type, price, quantity, manufacturer_id) VALUES " +
                    "('Rolex Submariner', 'Mechanical', 10000, 5, 1), " +
                    "('Casio G-Shock', 'Quartz', 150, 20, 2), " +
                    "('Omega Seamaster', 'Mechanical', 8000, 3, 3), " +
                    "('Seiko Presage', 'Quartz', 500, 10, 4)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

