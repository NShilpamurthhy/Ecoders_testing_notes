package database_tesing_allora.mysql;

import java.sql.*;
import java.util.Scanner;

public class MySQLDatabaseOperations {

    // Function to establish a connection to MySQL
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

            if (conn != null) {
                System.out.println("Connected successfully to MySQL.");
            } else {
                System.out.println("Unable to connect to MySQL.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    // Function to show all tables in the "ecoders" database
    public static void showAllTablesInDatabase() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement("SHOW TABLES");
                ResultSet rs = ps.executeQuery();

                System.out.println("All tables from 'ecoders' database:");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Function to show all databases
    public static void showAllDatabases() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement("SHOW DATABASES");
                ResultSet rs = ps.executeQuery();

                System.out.println("All databases:");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Function to show all data from the "student" table
    public static void showAllStudentTableData() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.setCatalog("ecoders");  // Switch to the "ecoders" database
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM student");
                ResultSet rs = ps.executeQuery();

                System.out.println("id || name || Address");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Function to create a "student" table
    public static void createStudentTable() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.setCatalog("ecoders");
                PreparedStatement ps = conn.prepareStatement(
                        "CREATE TABLE IF NOT EXISTS student (id INT(45) AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), address VARCHAR(100))");

                int rs = ps.executeUpdate();
                if (rs == 0) {
                    System.out.println("Table created successfully.");
                } else {
                    System.out.println("Unable to create table.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Function to insert into the "student" table
    public static void insertIntoStudentTable() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.setCatalog("ecoders");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO student (name, address) VALUES (?, ?)");

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a name:");
                String name = sc.nextLine();
                System.out.println("Enter an address:");
                String address = sc.nextLine();

                ps.setString(1, name);
                ps.setString(2, address);

                int rs = ps.executeUpdate();
                if (rs > 0) {
                    System.out.println("Inserted successfully.");
                } else {
                    System.out.println("Unable to insert into the table.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Function to update a student's information
    public static void updateStudentTable() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.setCatalog("ecoders");
                PreparedStatement ps = conn.prepareStatement("UPDATE student SET name = ? WHERE id = ?");

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a name:");
                String name = sc.nextLine();
                System.out.println("Enter the ID for whom you want to update:");
                int id = sc.nextInt();

                ps.setString(1, name);
                ps.setInt(2, id);

                int rs = ps.executeUpdate();
                if (rs > 0) {
                    System.out.println("Update successful.");
                } else {
                    System.out.println("Unable to update the table.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Function to delete a student from the table
    public static void deleteFromStudentTable() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.setCatalog("ecoders");
                PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE id = ?");

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the ID you want to delete:");
                int id = sc.nextInt();

                ps.setInt(1, id);

                int rs = ps.executeUpdate();
                if (rs > 0) {
                    System.out.println("Deletion successful.");
                } else {
                    System.out.println("Unable to delete the record.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Function to get the second maximum salary from the "emp" table
    public static void getSecondMaxSalary() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.setCatalog("ecoders");
                PreparedStatement ps = conn.prepareStatement("SELECT MAX(sal) FROM emp WHERE sal < (SELECT MAX(sal) FROM emp)");

                ResultSet rs = ps.executeQuery();
                System.out.println("Second maximum salary is:");
                if (rs.next()) {
                    System.out.println(rs.getInt(1));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Main method to call all functions one by one
    public static void main(String[] args) {
//        showAllDatabases();
//        showAllTablesInDatabase();
    	showAllStudentTableData();
//        createStudentTable();
//        insertIntoStudentTable();
//        updateStudentTable();
       // deleteFromStudentTable();
        //getSecondMaxSalary();
    }
}
