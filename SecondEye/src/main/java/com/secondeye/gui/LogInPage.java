package com.secondeye.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
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
        String username = userText.getText();
        String password = new String(passText.getPassword());

        try {
            // Encrypt the password
            String encryptedPassword;
            try {
                encryptedPassword = DatabaseManager.encryptPassword(password);
            } catch (NoSuchAlgorithmException ex) {
                System.err.println("Error encrypting password: " + ex.getMessage());
                return; // or handle the exception accordingly
            }

            // Ensure the database connection is open
            DatabaseManager.ensureDatabaseConnection();

            // Validate user credentials
            try (ResultSet rs = DatabaseManager.validateUserCredentials(username, encryptedPassword)) {
                if (rs.next()) {
                    String role = rs.getString("role");
                    int firstLogin = rs.getInt("firstLogin");
                    UserSessionEvent.setCurrentUser(new User(username, role));
                    handleFirstLogin(firstLogin, username);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error during login: " + ex.getMessage());
        }
    }

    // Helper method in LogInPage.java
    private void handleFirstLogin(int firstLogin, String username) {
        if (firstLogin == 1) {
            JOptionPane.showMessageDialog(frame, "This is your first login. Please change your password.");
            this.dispose();
            new ChangePassword().setVisible(true);
        } else if (firstLogin == 0) {
            JOptionPane.showMessageDialog(frame, "Welcome back, " + username + "!");
            // new LandingPage().setVisible(true);
        }
    }
}