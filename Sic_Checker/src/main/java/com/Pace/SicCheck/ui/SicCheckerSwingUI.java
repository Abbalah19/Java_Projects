package com.Pace.SicCheck.ui;

import javax.swing.*;

import com.Pace.SicCheck.Main.Main;

import java.awt.*;
import java.io.File;

public class SicCheckerSwingUI extends JFrame {
    private String inputFilePath;
    private String outputFilePath;
    private JFrame frame;

    public void createAndShowGUI() {
        frame = new JFrame("SIC Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout()); // Simplified layout for demonstration

        JTextField inputFileDisplayField = new JTextField(20);
        inputFileDisplayField.setEditable(false);
        JTextField resultFilePathField = new JTextField(20);

        JButton openFileButton = new JButton("Select Input File");
        openFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                inputFileDisplayField.setText(selectedFile.getAbsolutePath());
                setInputFilePath(selectedFile.getAbsolutePath());
                // System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
        });

        JButton saveResultButton = new JButton("Save Results To");
        // Step 2: Add ActionListener to the save button
        saveResultButton.addActionListener(e -> {
            // Create a file chooser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a directory to save");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Set to directories only

            // Disable the "All files" option.
            fileChooser.setAcceptAllFileFilterUsed(false);

            // Step 3: Open the file chooser dialog
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();

                // Step 4: Here you can use the selected directory path to save a file
                // For demonstration, let's just print the selected directory path
                // System.out.println("Selected directory: " +
                // selectedDirectory.getAbsolutePath());
                resultFilePathField.setText(selectedDirectory.getAbsolutePath());
                setOutputFilePath(selectedDirectory.getAbsolutePath());
            }
        });

        // Create the "About" button with an action listener
        JButton aboutButton = new JButton("About");
        aboutButton.addActionListener(e -> {
            // Display an about dialog or information
            JOptionPane.showMessageDialog(frame, "SIC Checker v1.0\n .", "About",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Create the "Exit" button with an action listener
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            // Close the application
            System.exit(0);
        });

        JButton dataCheckButton = new JButton("Check Data");
        dataCheckButton.addActionListener(e -> {
            String inputFilePath = getInputFilePath(); // Assuming you have a getter for the input file path
            String outputFilePath = getOutputFilePath() + ".txt"; // Assuming you have a getter for the output directory
                                                                  // path
            Main.processFile(inputFilePath, outputFilePath); // Call the static method in Main
            JOptionPane.showMessageDialog(frame, "Data checked and results saved.", "Data Check",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Create panels with FlowLayout for each row
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel midPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Add components to panels
        topPanel.add(aboutButton);
        topPanel.add(exitButton);
        midPanel.add(openFileButton);
        midPanel.add(inputFileDisplayField);
        bottomPanel.add(saveResultButton);
        bottomPanel.add(resultFilePathField);
        footerPanel.add(dataCheckButton);

        // Adjust the main frame layout to accommodate the panels
        frame.setLayout(new GridLayout(4, 1)); // 2 rows, 1 column for panels

        // Add panels to the frame
        frame.add(topPanel);
        frame.add(midPanel);
        frame.add(bottomPanel);
        frame.add(footerPanel);

        frame.setMinimumSize(new Dimension(400, 200)); // Set minimum size of the frame
        frame.pack();
        frame.setVisible(true);
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }
}