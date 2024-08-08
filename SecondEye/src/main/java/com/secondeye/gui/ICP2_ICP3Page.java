package com.secondeye.gui;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ICP2_ICP3Page extends JFrame {
    private JFrame frame = new JFrame();
    private String inputFilePath;
    private String outputFilePath;
    private JCheckBox sicCheckBox;
    private JCheckBox CCV_CCBCheckBox;
    private JCheckBox overRangeCheckBox;
    private JCheckBox negativeCheckBox;
    private JCheckBox internalSTDCheckBox;


    public ICP2_ICP3Page() {
        // Set up the frame
        frame = this;
        setTitle("SecondEye - ICP-OES Review");
        setSize(450, 400);
        setLayout(new GridLayout(0,1));
        add(createInputFilePanel());
        add(createOutputFilePanel());
        add(createCheckBoxPanel());
        add(createButtonPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        setUpMenu();  
    }

    private JPanel createInputFilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(new EmptyBorder(10,10,10,10));
        JTextField textField = new JTextField("Select Input File");
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(200, 30));
        JButton button = new JButton("Browse - Input Files");
        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            File userHome = new File("A:\\METALS-DATA");
            if (userHome.exists() && userHome.isDirectory()) {
                fileChooser.setCurrentDirectory(userHome);
            } else {
                // Handle the case where the directory does not exist
                System.out.println("The directory A:\\METALS-DATA does not exist. Setting to current working directory.");
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            }
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                inputFilePath = selectedFile.getAbsolutePath();
                textField.setText(inputFilePath);
            }
        });
        panel.add(textField);
        panel.add(button);
        return panel;
    }
    
    private JPanel createOutputFilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(new EmptyBorder(10,10,10,10));
        JTextField textField = new JTextField("Save Output File");
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(200, 30));
        JButton button = new JButton("Browse - Output Files");
        button.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();
            File metalsDataDir = new File("F:\\CTAL-Laboratory\\Inorganics\\Metals\\Second-Eye\\Output-Data");
            if (metalsDataDir.exists() && metalsDataDir.isDirectory()) {
                fileChooser.setCurrentDirectory(metalsDataDir);
            } else {
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            }

            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                outputFilePath = selectedFile.getAbsolutePath();
                if (!outputFilePath.endsWith(".txt")) {
                    outputFilePath += ".txt";
                }
                textField.setText(outputFilePath);
            }
        });
        panel.add(textField);
        panel.add(button);
        return panel;
    }
    
    private JPanel createCheckBoxPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3)); // 3 rows, 3 columns
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.setPreferredSize(new Dimension(200, 75));
        
        sicCheckBox = new JCheckBox("SIC Check"); // 1:1
        CCV_CCBCheckBox = new JCheckBox("Include CCV/CCB"); // 1:2
        overRangeCheckBox = new JCheckBox("Over Range (Dilution)"); // 1:3
        negativeCheckBox = new JCheckBox("Too Negative"); // 2:2
        internalSTDCheckBox = new JCheckBox("Y Range (50-150%)"); // 2:3

        panel.add(sicCheckBox);
        panel.add(CCV_CCBCheckBox);
        panel.add(overRangeCheckBox);
        panel.add(negativeCheckBox);
        panel.add(internalSTDCheckBox);
        return panel;
    }
    
    private JPanel createButtonPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.setBorder(new EmptyBorder(10,10,10,10));
            JButton button = new JButton("Review Data");
            JButton backToSelection = new JButton("Back to Selection");
            button.addActionListener(e -> {
                if (inputFilePath == null) {
                    JOptionPane.showMessageDialog(frame, "Please select input and output files");
                } else {

                    try {
                        inputFilePath = com.secondeye.EncodingDetection.convertToUTF8IfNeeded(inputFilePath);
                    } catch (IOException formatConversionError) {
                        // Handle the exception or rethrow it
                        formatConversionError.printStackTrace();
                    }
                    boolean sic = sicCheckBox.isSelected();
                    boolean CCV_CCB = CCV_CCBCheckBox.isSelected();
                    boolean overRange = overRangeCheckBox.isSelected();
                    boolean negative = negativeCheckBox.isSelected();
                    boolean internalSTD = internalSTDCheckBox.isSelected();

                    Object[] options = {"View Report", "Export Report", "Cancel"};
                    int choice = JOptionPane.showOptionDialog(
                        frame,
                        "What would you like to do?",
                        "Data Reviewed",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]
                    );

                    switch (choice){
                        case JOptionPane.YES_OPTION:    // View Report
                            com.secondeye.ICP2_ICP3_DataParse.parseData(inputFilePath);
                            com.secondeye.ICP2_ICP3_DataParse.reviewData("",
                            false, sic, CCV_CCB, overRange, negative, internalSTD);
                            break;
                        case JOptionPane.NO_OPTION:     // Export Report
                            if (outputFilePath == null) {
                                JOptionPane.showMessageDialog(frame, "Please select output path");
                            } else {
                                com.secondeye.ICP2_ICP3_DataParse.parseData(inputFilePath);
                                com.secondeye.ICP2_ICP3_DataParse.reviewData(outputFilePath,
                                true, sic, CCV_CCB, overRange, negative, internalSTD);
                            }
                            break;
                        case JOptionPane.CANCEL_OPTION: // Cancel
                            break;
                    }                    
                }
            });

            backToSelection.addActionListener(e -> {
                frame.dispose();
                new InsSelectionPage().setVisible(true);
            });
            panel.add(button);
            panel.add(backToSelection);
            return panel;
        }
    
    private void setUpMenu() {
        MenuBarUtil.setupMenuBar(this);
    }

    public static void reportPage(String report) {
        JTextArea textArea = new JTextArea(report);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10))); // Add a raised beveled border with padding
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 500));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
        // Create a resizable JDialog
        JDialog dialog = new JDialog((Frame) null, "Reviewer Report", true);
        dialog.getContentPane().add(scrollPane);
        dialog.setSize(800, 700);
        dialog.setResizable(true);
        dialog.setLocationRelativeTo(null); // Center the dialog
        dialog.setVisible(true);
    }

}
