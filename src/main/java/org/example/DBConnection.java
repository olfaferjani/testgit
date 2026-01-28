package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/challenge_db";
    private static final String USER = "testuser";
    private static final String PASSWORD = "test123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Connected to MySQL successfully!");
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery("SELECT DATABASE()");
            if (rs.next()) {
                System.out.println("Current database: " + rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
