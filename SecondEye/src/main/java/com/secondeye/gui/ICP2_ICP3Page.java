package com.secondeye.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
        setTitle("SecondEye - ICP2/ICP3 Review");
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
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            }

            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                outputFilePath = selectedFile.getAbsolutePath();
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
                if (inputFilePath == null || outputFilePath == null) {
                    JOptionPane.showMessageDialog(frame, "Please select input and output files");
                } else {
                    boolean sic = sicCheckBox.isSelected();
                    boolean CCV_CCB = CCV_CCBCheckBox.isSelected();
                    boolean overRange = overRangeCheckBox.isSelected();
                    boolean negative = negativeCheckBox.isSelected();
                    boolean internalSTD = internalSTDCheckBox.isSelected();
                    //com.Reviewer.DataReviewer.Main.parseData(inputFilePath);
                    //com.Reviewer.DataReviewer.Main.reviewData(outputFilePath+".txt", sic, CCV_CCB, overRange, calibration, 
                    //    negative, internalSTD);
                    JOptionPane.showMessageDialog(frame, "Data reviewed successfully");
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

}
