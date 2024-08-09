package com.secondeye.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.secondeye.InputChecks;
import com.secondeye.StringHelpers;
import com.secondeye.User;
import com.secondeye.UserSessionEvent;
import com.secondeye.database.AccountManager;

public class DevOptions extends JFrame {
    private JFrame frame = new JFrame();

    public DevOptions() {
        // Get the User object from UserSessionEvent
        User user = UserSessionEvent.getCurrentUser();
        String role = user.getRole();
        String username = user.getUsername();

        // Set up the frame
        frame = this;
        setTitle("SecondEye - Dev Options");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setUpMenu();
        
        JButton newUser = new JButton("Create New User");
        JButton deleteUser = new JButton("Delete User");
        JButton changePassword = new JButton("Change Password");
        JButton seeUsers = new JButton("See Users");
        JButton info = new JButton("Info");
        JButton back = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10)); // 1 row, 4 columns, 10px horizontal and vertical gaps
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding
        buttonPanel.add(newUser);
        buttonPanel.add(deleteUser);
        buttonPanel.add(changePassword);
        buttonPanel.add(seeUsers);
        buttonPanel.add(info);
        buttonPanel.add(back);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(Box.createVerticalGlue()); // Add vertical glue to push the button panel to the center
        containerPanel.add(buttonPanel);
        containerPanel.add(Box.createVerticalGlue()); // Add vertical glue to push the button panel to the center
    
        add(containerPanel);
        setVisible(true);

        newUser.addActionListener(e -> {
            if (role.equals("DEV") || role.equals("ADMIN")) {        
                JPanel newUserPanel = new JPanel(new GridLayout(0,1));
                newUserPanel.add(new JLabel("Username:"));
                JTextField usernameField = new JTextField();
                newUserPanel.add(usernameField);
        
                newUserPanel.add(new JLabel("Password:"));
                JPasswordField passwordField = new JPasswordField();
                newUserPanel.add(passwordField);
        
                newUserPanel.add(new JLabel("Role (ADMIN or USER):"));
                JTextField roleField = new JTextField();
                newUserPanel.add(roleField);
        
                // Show the dialog
                int result = JOptionPane.showConfirmDialog(null, newUserPanel,
                "S-E Account Service", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
                // Process the input if OK is pressed
                if (result == JOptionPane.OK_OPTION) {
                    String usernameForNewUser = InputChecks.sanitizeInput(usernameField.getText());
                    String passwordForNewUser = InputChecks.sanitizeInput(new String(passwordField.getPassword()));
                    String roleForNewUser = InputChecks.sanitizeInput(roleField.getText().toUpperCase());
                    if (!roleForNewUser.equals("ADMIN") && !roleForNewUser.equals("USER")) {
                        JOptionPane.showMessageDialog(frame, "User role must be ADMIN or USER",
                        "S-E Account Service", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try{
                    if (AccountManager.checkForExistingUser(usernameForNewUser)){
                        JOptionPane.showMessageDialog(frame, "Error: User already exists",
                        "S-E Account Service", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    AccountManager.addNewUser(usernameForNewUser, passwordForNewUser, roleForNewUser);
                    JOptionPane.showMessageDialog(frame, "Account Added.",
                    "S-E Account Service", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "S-E Account Service",
                         JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Dialog was canceled.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "You do not have permission to create a new user.",
                "S-E Account Service", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteUser.addActionListener(e -> {
            if (role.equals("DEV") || role.equals("ADMIN")) {
                JPanel deleteUserPanel = new JPanel(new GridLayout(0, 1));
                deleteUserPanel.add(new JLabel("Username:"));
                JTextField usernameField = new JTextField();
                deleteUserPanel.add(usernameField);
        
                // Show the dialog
                int result = JOptionPane.showConfirmDialog(null, deleteUserPanel, "S-E Account Service", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
                // Process the input if OK is pressed
                if (result == JOptionPane.OK_OPTION) {
                    String usernameForDelete = InputChecks.sanitizeInput(usernameField.getText());
                    try {
                        if (!AccountManager.checkForExistingUser(usernameForDelete)) {
                            JOptionPane.showMessageDialog(frame, "Error: User does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        int deleteResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (deleteResult == JOptionPane.YES_OPTION) {
                            AccountManager.deleteUser(usernameForDelete);
                            JOptionPane.showMessageDialog(frame, "Account Deleted.",
                            "S-E Account Service", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                        "S-E Account Service", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Dialog was canceled.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "You do not have permission to delete a user.",
                "S-E Account Service", JOptionPane.ERROR_MESSAGE);
            }
        });
 
        changePassword.addActionListener(e -> {
            if (!role.matches("DEV") && !role.matches("ADMIN")) {
                JOptionPane.showMessageDialog(frame, "You do not have permission to change a user's password.",
                "S-E Account Service", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JPanel changePasswordPanel = new JPanel(new GridLayout(0, 1));
            changePasswordPanel.add(new JLabel("Username:"));
            JTextField usernameField = new JTextField();
            changePasswordPanel.add(usernameField);
    
            changePasswordPanel.add(new JLabel("New Password:"));
            JPasswordField passwordField = new JPasswordField();
            changePasswordPanel.add(passwordField);
    
            // Show the dialog
            int result = JOptionPane.showConfirmDialog(null, changePasswordPanel,
             "S-E Account Service", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
            // Process the input if OK is pressed
            if (result == JOptionPane.OK_OPTION) {
                String usernameForPasswordChange = InputChecks.sanitizeInput(usernameField.getText());
                String passwordForPasswordChange = InputChecks.sanitizeInput(new String(passwordField.getPassword()));
                try {
                    if (usernameForPasswordChange.matches("MJH") && !username.matches("MJH")) {
                        JOptionPane.showMessageDialog(frame,
                        "You'll Have to do better than that if you want to mess with my account.",
                        "S-E Account Service", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!AccountManager.checkForExistingUser(usernameForPasswordChange)) {
                        JOptionPane.showMessageDialog(frame, "Error: User does not exist",
                        "S-E Account Service", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int changeResult = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to change this password?", "S-E Account Service",
                    JOptionPane.YES_NO_OPTION);

                    if (changeResult == JOptionPane.YES_OPTION){
                    AccountManager.changePassword(usernameForPasswordChange, passwordForPasswordChange);
                    JOptionPane.showMessageDialog(frame, "Password Changed.", "S-E Account Service", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                    "S-E Account Service", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Dialog was canceled.");
            } 
        });
        
        seeUsers.addActionListener(e -> {
            if (!role.matches("DEV") && !role.matches("ADMIN")) {
                JOptionPane.showMessageDialog(frame, "You do not have permission to see users accounts.",
                "S-E Account Service", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                String usersTable = AccountManager.getUserTable();
                JTextArea textArea = new JTextArea(usersTable);
                textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 500));
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                JOptionPane.showMessageDialog(frame, scrollPane, "Users", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "S-E Account Service", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        info.addActionListener(e -> {
            JTextArea textArea = new JTextArea(StringHelpers.DEV_NOTES);
            textArea.setEditable(true); // allow editing... it doesn't save so run wild
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JOptionPane.showMessageDialog(frame, scrollPane, "About", JOptionPane.INFORMATION_MESSAGE);
        });

        back.addActionListener(e -> {
            frame.dispose();
            new LandingPage().setVisible(true);
        });
    }

    private void setUpMenu() {
        MenuBarUtil.setupMenuBar(this);
    }
    
}