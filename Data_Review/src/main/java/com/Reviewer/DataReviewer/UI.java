package com.Reviewer.DataReviewer;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI extends JFrame{
    private String inputFilePath;
    private String outputFilePath;
    private JFrame frame;
    private JCheckBox sicCheckBox;
    private JCheckBox CCV_CCBCheckBox;
    private JCheckBox overRangeCheckBox;
    private JCheckBox calibrationCheckBox;
    private JCheckBox negativeCheckBox;
    private JCheckBox internalSTDCheckBox;

    public static String passwordX;

    public void createGUI() {
        frame = new JFrame("Data Reviewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 1));
        frame.add(createAboutPanel());
        frame.add(createInputFilePanel());
        frame.add(createOutputFilePanel());
        frame.add(createCheckBoxPanel());
        frame.add(createButtonPanel());
        

        String password = JOptionPane.showInputDialog(frame, "Enter your password:");
        setPassword(password);
        if ("secret".equals(password) || "AJ".equals(password) || "JLC".equals(password)) {
            if ("secret".equals(password)) {
                JOptionPane.showMessageDialog(frame, "Welcome to the Data Reviewer program!");
                frame.setVisible(true);
            } else {
            JOptionPane.showMessageDialog(frame, StringHelpers.getRandomMessage());
            frame.setVisible(true);
        }
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect password, access denied.");
            System.exit(0);
        }
    }
    public static String getPassword() {
        return passwordX;
    }
    public static void setPassword(String password) {
        passwordX = password;
    }

    private JPanel createAboutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JButton button = new JButton("About");
        button.addActionListener(e -> {
            JTextArea textArea = new JTextArea(ABOUT_STRING);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);
            
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 400)); // Set the preferred size
            
            JOptionPane.showMessageDialog(frame, scrollPane, "About", JOptionPane.INFORMATION_MESSAGE);
        });
        
        JButton button2 = new JButton("Exit");
        button2.addActionListener(e -> {
            System.exit(0);
        });
        
        panel.add(button);
        panel.add(button2);
        
        return panel;
    }

    private JPanel createInputFilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JTextField textField = new JTextField("Select Input File");
        textField.setPreferredSize(new Dimension(200, 30));
        JButton button = new JButton("Browse - Input Files");
        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
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
        JTextField textField = new JTextField("Save Output File");
        textField.setPreferredSize(new Dimension(200, 30));
        JButton button = new JButton("Browse - Output Files");
        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
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
        sicCheckBox = new JCheckBox("SIC Check"); // 1:1
        CCV_CCBCheckBox = new JCheckBox("Include CCV/CCB"); // 1:2
        overRangeCheckBox = new JCheckBox("Over Range (Dilution)"); // 1:3
        calibrationCheckBox = new JCheckBox("Calibration QC"); // 2:1
        negativeCheckBox = new JCheckBox("Too Negative"); // 2:2
        internalSTDCheckBox = new JCheckBox("Y Range (50-150%)"); // 2:3

        panel.add(sicCheckBox);
        panel.add(CCV_CCBCheckBox);
        panel.add(overRangeCheckBox);
        panel.add(calibrationCheckBox);
        panel.add(negativeCheckBox);
        panel.add(internalSTDCheckBox);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton button = new JButton("Review Data");
        button.addActionListener(e -> {
            if (inputFilePath == null || outputFilePath == null) {
                JOptionPane.showMessageDialog(frame, "Please select input and output files");
            } else {
                boolean sic = sicCheckBox.isSelected();
                boolean CCV_CCB = CCV_CCBCheckBox.isSelected();
                boolean overRange = overRangeCheckBox.isSelected();
                boolean calibration = calibrationCheckBox.isSelected();
                boolean negative = negativeCheckBox.isSelected();
                boolean internalSTD = internalSTDCheckBox.isSelected();
                com.Reviewer.DataReviewer.Main.parseData(inputFilePath);
                com.Reviewer.DataReviewer.Main.reviewData(outputFilePath+".txt", sic, CCV_CCB, overRange, calibration, 
                    negative, internalSTD);
                JOptionPane.showMessageDialog(frame, StringHelpers.getRandomMessage());
            }
        });
        panel.add(button);
        return panel;
    }

    private static final String ABOUT_STRING = "Data Reviewer Version 2.1\n\nThis program is still in development!!!\n\n" +
            "The stuff you need to know:\n" +
            "This is a test program and as such you should expect bugs, typos and unexpected behavior. "+
            "You can report bugs to me and, IF I feel like it, I'll fix them. Otherwise, just be aware "+
            "that this program is not meant to be used by untrained data reviewers and is not meant to "+
            "replace traditional review practices. Double check all limits and don't trust me to have "+
            "coded them all in, mostly from memory, correctly.\n\n"+
            "Other than that, if this helps you get through your day, then I am happy to have helped.\n"+
            "-Matt\n\n"+
            "Known Issues:\n"+
            "- Bugs -> ICP4 has slightly different ID's so it checks more points then I want, easy fix, I'll get to it \n"+
            "- Issue -> ICP4 data manager exports in little endian, not UTF-8..... why? WHY? Who exports files this way? "+
            " This will be a headache, don't expect a fix soon. ( try block -> if UTF-8 :), else :(   ?)\n\n"+
            "Only the Sic check, negative values and IS check is implemented at this time. In most cases " +
            "Instrument QC, Calibration and Rinse samples are ignored by the checks.\n\n"+
            "The current program uses a lot of string matching to identify what sample is being checked and "+
            "position matching from the prn file to identify what data from that sample is being checked. "+
            "Changes to ID's or changes to data manager templates will break things. It will be a simple fix though.\n\n"+
            "\n\nAll the Crap you don't care about and probably won't read:\n\n"+

            "- Negative value check has been reworked to use a map from ReportingLevelMap class to check the data, "+
            "this should help with future checks like CCB and calibration.\n\n"+
            
            "- Set up custom messages for AJ and JLC, default password is 'secret'.\n\n"+
            
            "- The current password system is hardcoded and is only there becuase I was playing around. "+
            "Do not expect any meaningful security. If in some far distant time, I am bored then, I might "+
            "tie in some SQL like databases and then once we can store data, security might become important.\n\n"+

            "- The current prn file format does not include the data to calculate RE's or R2 values from "+
            "the cal and adding it to the format might break how it is read for element. This may not "+
            "be a problem on the new system but for now......\n\n" +
            
            "- The current structure scans through a prn file and builds an arrayList object from each row. A "+
            "second iteration over the list groups the data objects into another arrayList based on the "+
            "sample id and time. This isn't exactly efficient but we might make up time for actions that "+
            "have to scan back or forth through the data. We'll see.\n\n"+
            
            "- The objects created for the inner list actually collect more data then is currently used. This "+
            "is is becuase I might want to add more checks in the future and I don't want to modify my class.\n\n";
}