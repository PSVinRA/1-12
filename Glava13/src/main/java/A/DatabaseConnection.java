package A;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.Driver;
//Романов Альберт Б762-2 Вариант 9
public class DatabaseConnection {
    private static final String URL = "jdbc:h2:./watchstore";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}