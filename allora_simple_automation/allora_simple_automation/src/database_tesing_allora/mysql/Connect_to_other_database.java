package database_tesing_allora.mysql;

import java.sql.*;

public class Connect_to_other_database {

    // Function to connect to a specific database
    public static void connectToDatabase(String databaseName) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create a connection string with the specified database name
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, "root", "root");

            if (conn == null) {
                System.out.println("Unable to connect to " + databaseName);
            } else {
                System.out.println("Connected successfully to " + databaseName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Main method to call connectToDatabase with different databases
    public static void main(String[] args) {
        // Connect to different databases
        connectToDatabase("mysql");        // Default MySQL database
        connectToDatabase("ecoders");      // Example: Connect to 'ecoders' database
      //  connectToDatabase("testdb");       // Example: Connect to 'testdb' database
      //  connectToDatabase("employee_db"); // Example: Connect to 'employee_db' database
    }
}
