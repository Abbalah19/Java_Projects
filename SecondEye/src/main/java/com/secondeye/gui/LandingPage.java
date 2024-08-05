package com.secondeye.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.secondeye.User;
import com.secondeye.UserSessionEvent;

public class LandingPage extends JFrame {
    private JFrame frame = new JFrame();

    public LandingPage() {
        User user = UserSessionEvent.getCurrentUser();
        String role = user.getRole();
        String username = user.getUsername();
        // For when I'm feeling evil
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(2024, 12, 14);
        if (today.isAfter(endDate) && !username.matches("MJH")) {
            JOptionPane.showMessageDialog(frame, "Your trial has expired. Please contact the developer.",
                    "S-E Account Service", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        // Set up the frame
        frame = this;
        setTitle("SecondEye");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        setUpMenu();
    
        // Create the panel with buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10)); // 1 row, 4 columns, 10px horizontal and vertical gaps
        buttonPanel.setPreferredSize(new Dimension(550, 50)); // Set preferred size
        buttonPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding

        JButton dataReviewButton = new JButton("Data Review");
        JButton labCalculationsButton = new JButton("Lab Calculations");
        JButton inProgressButton = new JButton("InProgress");
        JButton devOptionsButton = new JButton("Dev Options");

        // Add buttons to the panel
        buttonPanel.add(dataReviewButton);
        buttonPanel.add(labCalculationsButton);
        buttonPanel.add(inProgressButton);
        buttonPanel.add(devOptionsButton);

        // Create a container panel with BoxLayout to center the button panel vertically
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(Box.createVerticalGlue()); // Add vertical glue to push the button panel to the center
        containerPanel.add(buttonPanel);
        containerPanel.add(Box.createVerticalGlue()); // Add vertical glue to push the button panel to the center

        // Add the container panel to the center of the frame
        add(containerPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);

        dataReviewButton.addActionListener(e -> {
            frame.dispose();
            new InsSelectionPage().setVisible(true);
        });

        devOptionsButton.addActionListener(e -> {
            if (role.matches("DEV") || role.matches("ADMIN")) {
                frame.dispose();
                new DevOptions().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "You do not have permission to access this page.",
                 "S-E Account Service", JOptionPane.ERROR_MESSAGE);
            }            
        });
    }

    private void setUpMenu() {
        MenuBarUtil.setupMenuBar(this);
    }
}
