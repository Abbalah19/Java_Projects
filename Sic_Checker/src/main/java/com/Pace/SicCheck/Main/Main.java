package com.Pace.SicCheck.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

import com.Pace.SicCheck.models.ICP2_SIC;
import com.Pace.SicCheck.models.ICP3_SIC;
import com.Pace.SicCheck.models.ICP4_SIC;
import com.Pace.SicCheck.models.Measurement;

import javax.swing.SwingUtilities;

import com.Pace.SicCheck.models.CCV;
import com.Pace.SicCheck.models.StringHelper;
import com.Pace.SicCheck.ui.SicCheckerSwingUI;

public class Main {
    private static List<Measurement> measurements = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SicCheckerSwingUI().createAndShowGUI();
            }
        });
    }

    public static void processInputFile(String inputFilePath) {
        measurements.clear(); // Clear the list before processing a new file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            br.readLine(); // Read and ignore the first line (header)
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(","); // split on commas

                // Use a helper method to safely get fields with checks for null or empty values
                String sampleId = safeGetField(fields, 0);
                String instrumentID = safeGetField(fields, 2);
                String date = safeGetField(fields, 6);
                String time = safeGetField(fields, 7);
                String analyteName = safeGetField(fields, 10);
                double reportedConc = safeParseDouble(safeGetField(fields, 13), 0.0); // Default to 0.0 if parsing fails

                Measurement measurement = new Measurement(sampleId, instrumentID, date, time, analyteName,
                        reportedConc);
                measurements.add(measurement);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processOutputFile(String outputFilePath) {
        ICP2_SIC icp2 = new ICP2_SIC();
        ICP3_SIC icp3 = new ICP3_SIC();
        ICP4_SIC icp4 = new ICP4_SIC();
        CCV CCV = new CCV();

        try (FileWriter fw = new FileWriter(outputFilePath, true);
                PrintWriter pw = new PrintWriter(fw)) {

            for (Measurement measurement : measurements) {
                String sampleName = measurement.getSampleId();
                String instrumentID = measurement.getInstrumentID();
                String date = measurement.getDate();
                String time = measurement.getTime();
                String analyteName = measurement.getAnalyteName();
                double reportedConc = measurement.getReportedConc();

                String sampleBreak = new StringHelper().getSampleBreak();
                String seperator = new StringHelper().getSeperator();
                //String footer = new StringHelper().getFooter();

                String sicMsg = "";

                if (instrumentID == null && "Ag".equals(analyteName)) {
                    pw.println(sampleBreak);
                    pw.println(sampleName + " ICP " + date + " " + time + "\n");
                    continue;
                }

                if ("Ag".equals(analyteName)) {
                    pw.println(sampleBreak);
                    pw.println(sampleName + " " + instrumentID + " " + date + " " + time + "\n");
                }
                    
                if ("ICP2".equals(instrumentID)){
                icp2.checkAndBuildMessage(analyteName, reportedConc);
                sicMsg += icp2.getMessage();
                }
                if ("ICP3".equals(instrumentID)){
                    icp3.checkAndBuildMessage(analyteName, reportedConc);
                    sicMsg += icp3.getMessage();
                }
                if ("ICP4".equals(instrumentID)){
                    icp4.checkAndBuildMessage(analyteName, reportedConc);
                    sicMsg += icp4.getMessage();
                }
            
                if ("Zr".equals(analyteName)) {
                    if(!sicMsg.isEmpty()){
                        pw.println(seperator);
                        pw.println("~ Possible Interferences ~\n" + sicMsg);
                    }
                    resetICPMessage(pw, icp2, icp3, icp4, CCV);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void resetICPMessage(PrintWriter pw, ICP2_SIC icp2, ICP3_SIC icp3, ICP4_SIC icp4, CCV CCV) {
        String footer = new StringHelper().getFooter();
        icp2.setMessage(""); // Reset the message to default
        icp2.setMessage(""); // Reset the message to default
        icp3.setMessage("");
        icp4.setMessage("");
        CCV.setMessage("");
        pw.println(footer + "\n");
    }

    private static String safeGetField(String[] fields, int index) {
        if (index >= 0 && index < fields.length) {
            return fields[index].trim().isEmpty() ? null : fields[index].trim();
        }
        return null;
    }

    private static double safeParseDouble(String value, double defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}