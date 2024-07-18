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

    public static String passwordX = "secret";

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
        if ("secret".equals(password) || "AJ".equals(password)) {
            JOptionPane.showMessageDialog(frame, "Welcome, authorized user!");
            passwordX = password;
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect password, access denied.");
            System.exit(0);
        }
    }
    public static String getPassword() {
        return passwordX;
    }

    private JPanel createAboutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton button = new JButton("About");
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, ABOUT_STRING);
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
        sicCheckBox = new JCheckBox("SIC"); // 1:1
        CCV_CCBCheckBox = new JCheckBox("CCV/CCB"); // 1:2
        overRangeCheckBox = new JCheckBox("Over Range"); // 1:3
        calibrationCheckBox = new JCheckBox("Calibration"); // 2:1
        negativeCheckBox = new JCheckBox("Negative"); // 2:2
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

    private static final String ABOUT_STRING = "Data Reviewer\nVersion 2.0\nThis program is still in development!!!\n" +
            "You should expect bugs, typos and unexpected behavior. You can report bugs to me and, IF I feel like it, I'll" +
            " fix them.\nOtherwise, just be aware that this program is not meant to be used by untrained data" +
            " reviewers and is not meant to replace traditional review practices. Double check all limits and don't trust" +
            " me to have coded them all in, mostly from memory, correctly.\nOther than that, if this helps you" +
            " get through your day, then I am happy to have helped. Enjoy!\n\nKnown Bugs:\n - None (don't worry, we'll" +
            " find some)\n Only the Sic check and IS check is implemented at this time. Samples being to negative is coming next";
}