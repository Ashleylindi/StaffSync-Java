package za.database_related;

import java.sql.*;
import static java.sql.DriverManager.getConnection;

public class DatabaseConnection {

    // Database URL
    private static final String DATABASE_URL = "jdbc:sqlite:staffsync.db"; // Your SQLite file here

    // Establishing the connection to the database
    public static Connection connect() {
        Connection connection = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Create the connection to the database
            connection = getConnection(DATABASE_URL);

            System.out.println("Connected to the database!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
