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

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
