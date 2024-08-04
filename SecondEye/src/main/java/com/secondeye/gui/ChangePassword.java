package com.secondeye.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.secondeye.InputChecks;
import com.secondeye.database.AccountManager;

public class ChangePassword extends JFrame {
    private JFrame frame = new JFrame();

    public ChangePassword() {
        // Set up the frame
        setTitle("Change Password");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding

        // Create components
        JLabel usernameLabel = new JLabel("UserName:");
        JTextField usernameText = new JTextField(20);
        JLabel passLabel = new JLabel("Current Password:");
        JPasswordField passText = new JPasswordField(20);
        JLabel newPassLabel = new JLabel("New Password:");
        JPasswordField newPassText = new JPasswordField(20);
        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPassText = new JPasswordField(20);
        JButton changeButton = new JButton("Change Password");
        JButton backButton = new JButton("Back");

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(usernameText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(passLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(passText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(newPassLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(newPassText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(confirmPassLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(confirmPassText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(changeButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(backButton, gbc);

// Add action listener to the button
changeButton.addActionListener(e -> {
    // Handle password change logic here
    String username = InputChecks.sanitizeInput(usernameText.getText());
    String currentPassword = InputChecks.sanitizeInput(new String(passText.getPassword()));
    String newPassword = InputChecks.sanitizeInput(new String(newPassText.getPassword()));
    String confirmPassword = InputChecks.sanitizeInput(new String(confirmPassText.getPassword()));
    
    if (checkPasswords(newPassword, confirmPassword)) {
        try {
            AccountManager.validateUserCredentials(username, currentPassword);
            AccountManager.updatePassword(username, newPassword);
            // Display a success message
            JOptionPane.showMessageDialog(frame, 
            "Password changed successfully.", 
            "S-E Account Service", 
            JOptionPane.INFORMATION_MESSAGE);
            // Close the current window and open the landing page
            this.dispose();
            new LandingPage().setVisible(true);

        } catch (Exception er) {
            JOptionPane.showMessageDialog(frame, 
            "An error occurred while changing the password. Please try again.", 
            "S-E Account Service", 
            JOptionPane.ERROR_MESSAGE);
        }
    }
});

// Add action listener to the back button
backButton.addActionListener(e -> {
    this.dispose();
    new LogInPage().setVisible(true);
});
    }

    private boolean checkPasswords(String newPassword, String confirmPassword) {
        if (newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(frame, 
            "Your new password cannot be empty.", 
            "S-E Account Service", 
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(frame, 
            "Your new passwords do not match, please try again.", 
            "S-E Account Service", 
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (newPassword.length() < 4) {
            JOptionPane.showMessageDialog(frame, 
            "Your new password must be at least 4 characters long.", 
            "S-E Account Service", 
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (!newPassword.matches(".*[A-Z].*")) {
            JOptionPane.showMessageDialog(frame, 
            "Your new password must contain at least one uppercase letter.", 
            "S-E Account Service", 
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (!newPassword.matches(".*[a-z].*")) {
            JOptionPane.showMessageDialog(frame, 
            "Your new password must contain at least one lowercase letter.", 
            "S-E Account Service", 
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (!newPassword.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(frame, 
            "Your new password must contain at least one digit.", 
            "S-E Account Service", 
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        } 
        return true;
    }
}