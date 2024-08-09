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
import com.secondeye.UserSessionEvent;

public class MenuBarUtil {

    public static void setupMenuBar(JFrame frame) {
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        // Add menu items to the menu
        JMenuItem exitItemHelp = new JMenuItem("Exit");
        JMenuItem backToLogIn = new JMenuItem("Back to LogIn");
        JMenuItem aboutItemHelp = new JMenuItem("About");
        JMenuItem dataReviewHelp = new JMenuItem("Data Review");
        JMenuItem labCalculationsHelp = new JMenuItem("Lab Calculations");
        JMenuItem devOptionsHelp = new JMenuItem("Dev Options");
        JMenuItem patchNotes = new JMenuItem("Patch Notes");

        // Add menu items to the menu
        fileMenu.add(backToLogIn);
        fileMenu.add(exitItemHelp);

        helpMenu.add(aboutItemHelp);
        helpMenu.add(dataReviewHelp);
        helpMenu.add(labCalculationsHelp);
        helpMenu.add(devOptionsHelp);
        helpMenu.add(patchNotes);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Set the menu bar
        frame.setJMenuBar(menuBar);

        exitItemHelp.addActionListener(e -> System.exit(0));
        backToLogIn.addActionListener(e -> {
            UserSessionEvent.logOut();
            new LogInPage().setVisible(true);
            frame.dispose();
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

        patchNotes.addActionListener(e -> {
            JTextArea textArea = new JTextArea(StringHelpers.patchNotes);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JOptionPane.showMessageDialog(frame, scrollPane, "Patch Notes", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}