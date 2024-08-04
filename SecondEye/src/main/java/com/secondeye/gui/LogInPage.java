package com.secondeye.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.secondeye.User;
import com.secondeye.UserSessionEvent;
import com.secondeye.database.DatabaseManager;

public class LogInPage extends JFrame implements ActionListener {
    private JTextField userText;
    private JPasswordField passText;
    private JFrame frame;

    public LogInPage() {
        // Set up the frame
        setTitle("SecondEye Login");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        // Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding
    
        // Create components
        JLabel userLabel = new JLabel("Username:");
        userText = new JTextField(20);
        JLabel passLabel = new JLabel("Password:");
        passText = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
    
        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(userLabel, gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(userText, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(passLabel, gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(passText, gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);
    
        // Call a separate method to add action listener to the button
        addActionListenerToLoginButton(loginButton);
    }
    
    private void addActionListenerToLoginButton(JButton loginButton) {
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Retrieve user input
        String username = userText.getText();
        String password = new String(passText.getPassword());
    
        // Sanitize and handle the login logic here
        try {
            // Encrypt the password
            String encryptedPassword = DatabaseManager.encryptPassword(password);
    
            // Ensure the database connection is open
            if (DatabaseManager.connection == null || DatabaseManager.connection.isClosed()) {
                String relativePath = "src/main/java/com/secondeye/database/users.db";
                String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
                String url = "jdbc:sqlite:" + absolutePath;
                DatabaseManager.connection = DriverManager.getConnection(url);
            }
    
            // Prepare the SQL query
            String query = "SELECT role, firstLogin FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = DatabaseManager.connection.prepareStatement(query)) {
                // Set query parameters
                pstmt.setString(1, username);
                pstmt.setString(2, encryptedPassword);
    
                // Execute the query
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String role = rs.getString("role");
                        int firstLogin = rs.getInt("firstLogin");
                        UserSessionEvent.setCurrentUser(new User(username, role));
                        if (firstLogin == 1) {
                            JOptionPane.showMessageDialog(frame, "This is your first login. Please change your password.");
                            this.dispose();
                            new ChangePassword().setVisible(true);

                        } else if (firstLogin == 0) {
                            JOptionPane.showMessageDialog(frame, "Welcome back, " + username + "!");
                            // new LandingPage().setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                    }
                }
            }
        } catch (SQLException | NoSuchAlgorithmException ex) {
            System.err.println("Error during login: " + ex.getMessage());
        }
    }
}