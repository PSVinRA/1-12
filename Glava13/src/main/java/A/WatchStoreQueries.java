package A;
import A.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
public class WatchStoreQueries {
    private final Connection connection;

    public WatchStoreQueries(Connection connection) {
        this.connection = connection;
    }

    public List<String> getWatchesByType(String type) {
        List<String> brands = new ArrayList<>();
        String query = "SELECT brand FROM Watch WHERE type = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                brands.add(rs.getString("brand"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brands;
    }

    public List<String> getMechanicalWatchesUnderPrice(double maxPrice) {
        List<String> watches = new ArrayList<>();
        String query = "SELECT brand FROM Watch WHERE type = 'Mechanical' AND price <= ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, maxPrice);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                watches.add(rs.getString("brand"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return watches;
    }

    public List<String> getWatchesByCountry(String country) {
        List<String> brands = new ArrayList<>();
        String query = "SELECT Watch.brand FROM Watch JOIN Manufacturer ON Watch.manufacturer_id = Manufacturer.id WHERE Manufacturer.country = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, country);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                brands.add(rs.getString("brand"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brands;
    }

    public List<String> getManufacturersByTotalValueUnder(double maxValue) {
        List<String> manufacturers = new ArrayList<>();
        String query = "SELECT Manufacturer.name FROM Manufacturer JOIN Watch ON Manufacturer.id = Watch.manufacturer_id " +
                "GROUP BY Manufacturer.name HAVING SUM(Watch.price * Watch.quantity) <= ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, maxValue);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                manufacturers.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manufacturers;
    }
}

