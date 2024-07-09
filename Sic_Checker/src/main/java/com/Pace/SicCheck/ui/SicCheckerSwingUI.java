package com.Pace.SicCheck.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                resultFilePathField.setText(selectedDirectory.getAbsolutePath());
                setOutputFilePath(selectedDirectory.getAbsolutePath());
            }
        });

        // Create the "About" button with an action listener
        JButton aboutButton = new JButton("About");
        aboutButton.addActionListener(e -> {
            // Display an about dialog or information
            JOptionPane.showMessageDialog(frame, aboutMsg(), "About",
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

            /* 
             * This fucking line, Gradle did some sort of magic refactoring bullshit that took 4 hours to trace
             * back to. I don't know why, I don't care why but the code compiles whiouth errors now.
             */
            com.Pace.SicCheck.Main.Main.processInputFile(getInputFilePath());

            com.Pace.SicCheck.Main.Main.processOutputFile(getOutputFilePath()+"X.txt");

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

    private String aboutMsg() {
        return "SIC Checker v1.0\n\n" +
                "This is a simple test program. Designed to check ICP Data for being over the IEC limits.\n" +
                "It is only designed to work against the current Data Manager output format and will break\n" +
                "if the format changes. It is also only made to work with prn files, though it should be able\n" +
                "to handle a csv or txt format. It will add an X to your file output name, this is becuase I am\n" +
                "lazy and didn't want to add null/empty field catch statements.\n" +
                "As a test program, it is not designed to be user friendly, and will not handle errors well.\n" +
                "It is also not designed to be efficient, and will be slow with large files.\n" +
                "It is also not designed to be robust, and will break if the input file is not as expected.\n" +
                "It is also not fully edited, and will have spelling/numerical errors.\n\n" +
                "IT IS POSSIBLE TO OVERWRITE FILES WITH THIS PROGRAM, BE CAREFUL SELECTING A SAVE FILE\n" +
                "THIS IS NOT A REPLACEMENT FOR A PROPERRLY TRAINED ANALYST\n\n";
    }
}