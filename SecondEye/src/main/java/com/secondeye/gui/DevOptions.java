package com.secondeye.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.secondeye.StringHelpers;
import com.secondeye.User;
import com.secondeye.UserSessionEvent;

public class DevOptions extends JFrame {
    private JFrame frame = new JFrame();

    public DevOptions() {
        // Get the User object from UserSessionEvent
        User user = UserSessionEvent.getCurrentUser();
        String role = user.getRole();

        // Set up the frame
        frame = this;
        setTitle("SecondEye - Dev Options");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        // Add menu items to the menu
        JMenuItem exitItemHelp = new JMenuItem("Exit");
        JMenuItem backToMainPage = new JMenuItem("Back to Main Page");
        JMenuItem backToLogIn = new JMenuItem("Back to LogIn");
        JMenuItem aboutItemHelp = new JMenuItem("About");
        JMenuItem dataReviewHelp = new JMenuItem("Data Review");
        JMenuItem labCalculationsHelp = new JMenuItem("Lab Calculations");
        JMenuItem devOptionsHelp = new JMenuItem("Dev Options");

        // Add menu items to the menu
        fileMenu.add(exitItemHelp);
        fileMenu.add(backToMainPage);
        fileMenu.add(backToLogIn);

        helpMenu.add(aboutItemHelp);
        helpMenu.add(dataReviewHelp);
        helpMenu.add(labCalculationsHelp);
        helpMenu.add(devOptionsHelp);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Set the menu bar
        setJMenuBar(menuBar);

        exitItemHelp.addActionListener(e -> System.exit(0));
        backToMainPage.addActionListener(e -> {
            frame.dispose();
            new LandingPage().setVisible(true);
        });
        backToLogIn.addActionListener(e -> {
            UserSessionEvent.logOut();
            frame.dispose();
            new LogInPage().setVisible(true);
        });
        aboutItemHelp.addActionListener(e -> {
            JTextArea textArea = new JTextArea(StringHelpers.helpAbout);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JOptionPane.showMessageDialog(frame, scrollPane, "About", JOptionPane.INFORMATION_MESSAGE);
        });
        dataReviewHelp.addActionListener(e -> {
            JTextArea textArea = new JTextArea(StringHelpers.helpDataReview);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JOptionPane.showMessageDialog(frame, scrollPane, "Data Review Help", JOptionPane.INFORMATION_MESSAGE);
        });
        labCalculationsHelp.addActionListener(e -> {
            JTextArea textArea = new JTextArea(StringHelpers.helpLabCalculations);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JOptionPane.showMessageDialog(frame, scrollPane, "Calculation Help", JOptionPane.INFORMATION_MESSAGE);
        });
        devOptionsHelp.addActionListener(e -> {
            JTextArea textArea = new JTextArea(StringHelpers.helpDevOptions);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JOptionPane.showMessageDialog(frame, scrollPane, "Dev Options Help", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}