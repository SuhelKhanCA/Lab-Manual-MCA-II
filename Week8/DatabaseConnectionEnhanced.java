package Week8;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionEnhanced {

    public static class DatabaseConnectionException extends Exception {
        public DatabaseConnectionException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws DatabaseConnectionException {
        // Replace with your actual database credentials
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Perform database operations here using the connection object
            System.out.println("Successfully connected to the database!");
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Failed to connect to database: " + e.getMessage());
        } finally {
            System.out.println("Database connection closed.");
        }
    }
}
