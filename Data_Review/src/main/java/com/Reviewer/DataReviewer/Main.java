package com.Reviewer.DataReviewer;

import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    final private static List<ByAnalyte> innerList = new ArrayList<>();
    final private static List<BySampleID> sampleIDList = new ArrayList<>();

    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               new UI().createGUI();
           }
       }); 
    }

    public static void parseData(String inputFilePath){
        System.out.println("Parsing data from: " + inputFilePath);
        innerList.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))){
            br.readLine(); // Skip the header
            String line;
            while ((line = br.readLine()) != null){
                String[] fields = line.split(",");

                String sampleID = safeGetField(fields, 0);
                String userValue1 = safeGetField(fields, 2);
                String date = safeGetField(fields, 6);
                String time = safeGetField(fields, 7);
                String analyte_waveLength = safeGetField(fields, 8);
                Double concSamp = safeParseDouble(safeGetField(fields, 9), 0.0);
                String elem = safeGetField(fields, 10);
                Double wavelength = safeParseDouble(safeGetField(fields, 11), 0.0);
                Double concCalib = safeParseDouble(safeGetField(fields, 12), 0.0);
                Double reportedConc = safeParseDouble(safeGetField(fields, 13), 0.0);
                String calibUnits = safeGetField(fields, 14);
                String sampUnits = safeGetField(fields, 15);
                Double intCorr = safeParseDouble(safeGetField(fields, 16), 0.0);
                int repNumber1 = safeParseInt(safeGetField(fields, 17),0);
                Double concCalib1 = safeParseDouble(safeGetField(fields, 18), 0.0) ;
                Double concSamp1 = safeParseDouble(safeGetField(fields, 19), 0.0) ;
                int repNumber2 = safeParseInt(safeGetField(fields, 20), 0);
                Double concCalib2 = safeParseDouble(safeGetField(fields, 21), 0.0) ;
                Double concSamp2 = safeParseDouble(safeGetField(fields, 22), 0.0) ;
                int repNumber3 = safeParseInt(safeGetField(fields, 23), 0);
                Double concCalib3 = safeParseDouble(safeGetField(fields, 24), 0.0) ;
                Double concSamp3 = safeParseDouble(safeGetField(fields, 25), 0.0);
                int repNumber4 = safeParseInt(safeGetField(fields, 26), 0);
                Double concCalib4 = safeParseDouble(safeGetField(fields, 27), 0.0) ;
                Double concSamp4 = safeParseDouble(safeGetField(fields, 28), 0.0) ;

                ByAnalyte byAnalyte = new ByAnalyte(sampleID, userValue1, date, time, analyte_waveLength, 
                    concSamp, elem, wavelength, concCalib, reportedConc, calibUnits, sampUnits, intCorr, 
                    repNumber1, concCalib1, concSamp1, repNumber2, concCalib2, concSamp2, repNumber3, concCalib3, 
                    concSamp3, repNumber4, concCalib4, concSamp4);
                innerList.add(byAnalyte);
            }
        }
        catch (IOException e){
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
    private static int safeParseInt(String value, int defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}