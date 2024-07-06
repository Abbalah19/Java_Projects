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
import com.Pace.SicCheck.ui.SicCheckerSwingUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SicCheckerSwingUI().createAndShowGUI();
            }
        });
    }

    public static void processFile(String inputFilePath, String outputFilePath) {
        List<Measurement> measurements = new ArrayList<>();

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

        ICP2_SIC icp2 = new ICP2_SIC();
        ICP3_SIC icp3 = new ICP3_SIC();
        ICP4_SIC icp4 = new ICP4_SIC();

        try (FileWriter fw = new FileWriter(outputFilePath, true);
                PrintWriter pw = new PrintWriter(fw)) {

            for (Measurement measurement : measurements) {
                String sampleName = measurement.getSampleId();
                String instrumentID = measurement.getInstrumentID();
                String date = measurement.getDate();
                String time = measurement.getTime();
                String analyteName = measurement.getAnalyteName();
                double reportedConc = measurement.getReportedConc();

                String sampleResultString = sampleName + "  " + instrumentID + "  " + date + " " + time + " ";

                if (instrumentID == null && "Zr".equals(analyteName)) {
                    pw.println(sampleName + " ICP " + date + " " + time + "\n");
                    continue;
                }

                if ("ICP2".equals(instrumentID)) {
                    icp2.checkAndBuildMessage(analyteName, reportedConc);
                    sampleResultString += icp2.getMessage() + " ";
                }

                if ("ICP3".equals(instrumentID)) {
                    icp3.checkAndBuildMessage(analyteName, reportedConc);
                    sampleResultString += icp3.getMessage() + " ";
                }

                if ("ICP4".equals(instrumentID)) {
                    icp4.checkAndBuildMessage(analyteName, reportedConc);
                    sampleResultString += icp4.getMessage() + " ";
                }

                if ("Zr".equals(analyteName)) {
                    pw.println(sampleResultString + "\n");
                    icp2.setMessage(" "); // Reset the message to default
                    icp3.setMessage(" ");
                    icp4.setMessage(" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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