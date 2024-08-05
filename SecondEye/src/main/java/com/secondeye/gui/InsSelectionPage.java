package com.secondeye.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class InsSelectionPage extends JFrame {
        private JFrame frame = new JFrame();

    public InsSelectionPage() {
        // Set up the frame
        frame = this;
        setTitle("SecondEye");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        setUpMenu();

        // Create the panel with buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 5, 5)); // 1 row, 4 columns, 10px horizontal and vertical gaps
        buttonPanel.setPreferredSize(new Dimension(550, 100)); // Set preferred size
        buttonPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding

        JButton selectICP2 = new JButton("ICP-2");
        JButton selectICP3 = new JButton("ICP-3");
        JButton selectICP4 = new JButton("AVIO");
        JButton selectAgilent = new JButton("INPROGRESS");
        JButton selectNexion = new JButton("INPROGRESS");
        JButton selectFims = new JButton("INPROGRESS");
        JButton selectLeeman = new JButton("INPROGRESS");
        JButton selectBack = new JButton("Back");

        // Add buttons to the panel
        buttonPanel.add(selectICP2);
        buttonPanel.add(selectICP3);
        buttonPanel.add(selectICP4);
        buttonPanel.add(selectAgilent);
        buttonPanel.add(selectNexion);
        buttonPanel.add(selectFims);
        buttonPanel.add(selectLeeman);
        buttonPanel.add(selectBack);

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

        selectICP2.addActionListener(e -> {
            frame.dispose();
            //new ICP2_ICP3Page().setVisible(true);
        });

        selectICP3.addActionListener(e -> {
            frame.dispose();
            //new ICP2_ICP3Page().setVisible(true);
        });

        selectBack.addActionListener(e -> {
            frame.dispose();
            new LandingPage().setVisible(true);
        });
    }
    private void setUpMenu() {
        MenuBarUtil.setupMenuBar(this);
    }
}
