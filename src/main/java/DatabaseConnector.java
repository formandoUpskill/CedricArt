import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/artsydb";
        String user = "root";
        String password = "123";

        return DriverManager.getConnection(url, user, password);
    }
}
