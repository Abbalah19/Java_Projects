package com.secondeye.database;

// file paths and sql imports
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    public static Connection connection;

    public static void connect() {

        try {
            // Load the SQLite JDBC driver (you must have the sqlite-jdbc dependency in your project)
            Class.forName("org.sqlite.JDBC");

            // Create a connection to the database using a relative path
            String relativePath = "src/main/java/com/secondeye/database/users.db";
            String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
            String url = "jdbc:sqlite:" + absolutePath;
            connection = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableAndInsertDefaultUser() {
        try {
            // Create a sample table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " username text NOT NULL,\n"
                    + " password text NOT NULL,\n"
                    + " firstLogin integer,\n"
                    + " role text NOT NULL\n"
                    + ");";
            
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(createTableSQL);
    
                // Check if user 'MJH' exists
                String checkUserSQL = "SELECT COUNT(*) FROM users WHERE username = 'MJH';";
                try (ResultSet rs = stmt.executeQuery(checkUserSQL)) {
                    rs.next();
                    int count = rs.getInt(1);
    
                    if (count == 0) {
                        // Encrypt the password
                        String password = "DEV";
                        String encryptedPassword = null;
                        try {
                            encryptedPassword = encryptPassword(password);
                        } catch (NoSuchAlgorithmException e) {
                            System.err.println("Password encryption error: " + e.getMessage());
                        }
    
                        // Insert a default user if 'MJH' does not exist
                        String insertUserSQL = "INSERT INTO users (username, password, firstLogin, role) VALUES ('MJH', ?, 1, 'DEV');";
                        try (PreparedStatement pstmt = connection.prepareStatement(insertUserSQL)) {
                            pstmt.setString(1, encryptedPassword);
                            pstmt.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQL Error " + ex.getMessage());
        }
    }

    public static String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}