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

public class AccountManager {
    public static Connection connection;
    final private static String RELATIVEPATH = "./Bundle/database/users.db";
    final private static String TESTPATH = "./src/main/java/com/secondeye/database/users.db";

    // Change to relative path before packaging - keep on testPath for working in IDE
    final private static String ABSOLUTEPATH = Paths.get(TESTPATH).toAbsolutePath().toString();

    public static void connect() {

        try {
            // Load the SQLite JDBC driver (you must have the sqlite-jdbc dependency in your project)
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:" + ABSOLUTEPATH;
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

    public static void ensureDatabaseConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:sqlite:" + ABSOLUTEPATH;
            connection = DriverManager.getConnection(url);
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

    public static ResultSet validateUserCredentials(String username, String encryptedPassword) throws SQLException {
        ensureDatabaseConnection();
        String query = "SELECT role, firstLogin FROM users WHERE username = ? AND password = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, encryptedPassword);
        return pstmt.executeQuery();
    }

    public static void updatePassword(String username, String newPassword) throws SQLException {
        try {
            String encryptedPassword = encryptPassword(newPassword);
            ensureDatabaseConnection();
            
            String query = "UPDATE users SET password = ?, firstLogin = 0 WHERE username = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, encryptedPassword);
                pstmt.setString(2, username);
                pstmt.executeUpdate();
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password: " + e.getMessage(), e);
        }
    }

    public static boolean checkForExistingUser(String username) throws SQLException {
        ensureDatabaseConnection();
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }
    
    public static void addNewUser(String username, String password, String role) throws SQLException {
        try {
            String encryptedPassword = encryptPassword(password);
            ensureDatabaseConnection();            
            String query = "INSERT INTO users (username, password, firstLogin, role) VALUES (?, ?, 1, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, encryptedPassword);
                pstmt.setString(3, role);
                pstmt.executeUpdate();
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password: " + e.getMessage(), e);
        }
    }

    public static void deleteUser(String username) throws SQLException {
        ensureDatabaseConnection();
        String query = "DELETE FROM users WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        }
    }

    public static String getUserTable() throws SQLException {
        ensureDatabaseConnection();
        String query = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            StringBuilder table = new StringBuilder();
            
            // Add header
            table.append(String.format("%-3s | %-10s | %-5s | %-3s%n", "ID", "Username", "Role", "FirstLogin?"));
            table.append("-------------------------------------------------\n");
            
            // Add rows
            while (rs.next()) {
                table.append(String.format("%-3d | %-10s | %-5s | %-3d%n", 
                    rs.getInt("id"), 
                    rs.getString("username"), 
                    rs.getString("role"), 
                    rs.getInt("firstLogin")));
            }
            
            return table.toString();
        }
    }
}