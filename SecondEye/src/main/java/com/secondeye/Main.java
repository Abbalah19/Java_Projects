package com.secondeye;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the SQLite JDBC driver (you must have the sqlite-jdbc dependency in your project)
            Class.forName("org.sqlite.JDBC");
            
            // Create a connection to the database using a relative path
            String relativePath = "src/main/java/com/secondeye/database/users.db";
            String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
            String url = "jdbc:sqlite:" + absolutePath;
            connection = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
            // Create a sample table and insert a default user
            String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " username text NOT NULL,\n"
                    + " password text NOT NULL,\n"
                    + " firstLogIn integer,\n"
                    + " baseAccess integer,\n"
                    + " devAccess integer\n"
                    + " isMe integer\n"
                    + ");\n"
                    + "INSERT INTO users (username, password, flag1, flag2, flag3) VALUES ('MJH', 'DEVPASS', 1, 1, 1);";
            
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}