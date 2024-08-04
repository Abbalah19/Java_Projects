package com.secondeye.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ChangePassword extends JFrame {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JButton changePasswordButton;
    private JButton backButton;
    private JLabel usernameLabel;
    private JLabel oldPasswordLabel;
    private JLabel newPasswordLabel;
    private JLabel confirmPasswordLabel;

    public ChangePassword() {
        frame = new JFrame("Change Password");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 30);
        frame.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 30);
        frame.add(usernameField);

        oldPasswordLabel = new JLabel("Old Password:");
        oldPasswordLabel.setBounds(50, 100, 100, 30);
        frame.add(oldPasswordLabel);

        oldPasswordField = new JPasswordField();
        oldPasswordField.setBounds(150, 100, 200, 30);
        frame.add(oldPasswordField);

        newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setBounds(50, 150, 100, 30);
        frame.add(newPasswordLabel);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(150, 150, 200, 30);
        frame.add(newPasswordField);

        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(50, 200, 100, 30);
        frame.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(150, 200, 200, 30);
        frame.add(confirmPasswordField);

        changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(50, 250, 150, 30);
        frame.add(changePasswordButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 250, 150, 30);
        frame.add(backButton);
    }
}
