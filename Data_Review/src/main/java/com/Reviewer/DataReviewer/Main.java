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

    /*
     * This method will go through the input file and parse the data line by line into the "innerList" - ByAnalyte objects.
     * Next it will iterate over the innerList and group each sample into it's own object in the "outerList" - BySampleID objects.
     * It should look something like this:
     * SampleID1
     *     Analyte1
     *     Analyte2
     *     ...
     * SampleID2
     *    Analyte1
     *    Analyte2
     *    ...
     */
    public static void parseData(String inputFilePath){
        System.out.println(StringHelpers.getRandomMessage());
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

        sampleIDList.clear();
        for (ByAnalyte analyte : innerList){
            BySampleID sample = findOrCreateSample(analyte.getSampleID(), analyte.getDate(), analyte.getTime());
            sample.addAnalyte(analyte);
        }
        //printData();
    }

    /*
     * so what is the plan here?
     * 1. Create method that the UI class can call and pass the checkbox options and output file path too.
     * 2. open print writer and print a header at the top of the page.
     * 3. Start a for that goes through the outer list and uses a case statement to send the data
     *      to the correct review method based on the checkboxes passed in. Each statement should check if the
     *      checkbox is selected and if the data needs to be processed by the connected method. Each method
     *      should return a string that will be added to that samples stored string.
     * 4. After the case statement is done, print the sample strings to the output file.
     * 5. Clear the built up sample strings and start the next iteration of the for loop.
     * 6. After the for loop is done, print the footer to the output file and close the print writer.
     */
    public static void reviewData(String outputFilePath, boolean sic, boolean CCV_CCB, boolean overRange,
        boolean calibration, boolean negative, boolean internalSTD){
            String msg = "";
            try (Writers write = new Writers(outputFilePath, true)){
                write.writeLine("Data Review V2.1\n\n");

                /* For thesting the nested arralyList structure
                for (BySampleID sample : sampleIDList) {
                        write.writeLine("Sample ID: " + sample.getSampleID() + "sample time: " + sample.getTime(0));
                        for (ByAnalyte analyte : sample.getAnalytes()){
                            write.writeLine(analyte.toString());
                    }
                */

                for (BySampleID sample : sampleIDList) {
                    String sampleID = sample.getSampleID();
                    String insturmentID = sample.getInsturmentID(0) != null ? sample.getInsturmentID(0) : "ICP";
                    String date = sample.getDate(0);
                    String time = sample.getTime(0);
                    //System.out.println("~ " + sampleID + "  " + insturmentID + "   " + date + "    " + time + " ~");

                    if (!sample.getSampleID().matches("Cal Blank@.*") &&
                        !sample.getSampleID().matches("SEQ-CAL.*") &&
                        !sample.getSampleID().matches("RINSE.*") )
                    {
                        write.writeLine(pagePrinters(1));
                        write.writeLine("~ " + sampleID + "  " + insturmentID + "   " + date + "    " + time + " ~");
                        write.writeLine(pagePrinters(3));

                        if (internalSTD) {
                            msg = " ~ Internal Standard Check ~    \n"+ internalSTD(sample);
                            write.writeLine(msg+"\n");
                            write.writeLine(pagePrinters(3));
                        }
                        if (negative) {
                            msg = " ~ Negative Check ~ \n"+ negativeReview(sample);
                            write.writeLine(msg+"\n");
                            write.writeLine(pagePrinters(3));
                        }
                        if (sic) {
                            msg = " ~ Sic Check ~ \n"+ sicReview(sample);
                            write.writeLine(msg+"\n");
                            write.writeLine(pagePrinters(3));
                        }
                    }
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    private static String internalSTD(BySampleID sample){
            String msg = "";
            boolean failure = false;
            for (ByAnalyte analyte : sample.getAnalytes()){
                if (analyte.getAnalyteName().equals("Y axial") && analyte.getConcCalib() < 50.0){
                    msg += "  Y - Axial Failed Low.\n";
                    failure = true;
                } else if (analyte.getAnalyteName().equals("Y axial") && analyte.getConcCalib() > 150.0){
                    msg += "  Y - Axial Failed High.\n";
                    failure = true;
                }

                if (analyte.getAnalyteName().equals("Y radial") && analyte.getConcCalib() < 50.0){
                    msg += "  Y - Radial Failed Low.\n";
                    failure = true;
                } else if (analyte.getAnalyteName().equals("Y radial") && analyte.getConcCalib() > 150.0){
                    msg += "  Y - Radial Failed High.\n";
                    failure = true;
                }
            }
                if (!failure){
                    msg = "Internal Standard Passed.";
                }
            return msg;
        }
    private static String negativeReview(BySampleID sample){
        NegativeReview neg = new NegativeReview();
        String msg = "";
        for (ByAnalyte analyte : sample.getAnalytes()){
            double reportedConc = analyte.getReportedConc();
            String analyteName = analyte.getElem();
            neg.negChecker(analyteName, reportedConc);
            msg += neg.getMsg();
            neg.setMsgOver("");
        }
        if (msg.isEmpty()){
            msg = "Negative Check Passed.";
        }
        return msg;
    }
    private static String sicReview(BySampleID sample) {
            ICP2_Sic icp2 = new ICP2_Sic();
            ICP3_Sic icp3 = new ICP3_Sic();
            ICP4_Sic icp4 = new ICP4_Sic();
            String msg = "";
        
            for (ByAnalyte analyte : sample.getAnalytes()) {
                
                double reportedConc = analyte.getReportedConc();
                String analyteName = analyte.getElem();
                if ("ICP2".equals(analyte.getInsturmentID())) {
                    icp2.checkAndBuildMessage(analyteName, reportedConc);
                    msg += icp2.getMessage();
                    icp2.setMessage("");
                }
                if ("ICP3".equals(analyte.getInsturmentID())) {
                    icp3.checkAndBuildMessage(analyteName, reportedConc);
                    msg += icp3.getMessage();
                    icp3.setMessage("");
                }
                if ("ICP - 4".equals(analyte.getInsturmentID())) {
                    icp4.checkAndBuildMessage(analyteName, reportedConc);
                    msg += icp4.getMessage();
                    icp4.setMessage("");
                }               
            }
            if (msg.isEmpty()) {
                msg = "SIC Check Passed.";
            }
            return msg;
        }
    
        // adding the data and time check should isolate the data to the specific sample, removing the check will lump all samples
    // with the same id (i.e. rr's and ccv's) together. The zero index may cuase issues if the nested structure is changed.
    private static BySampleID findOrCreateSample(String sampleID, String date, String time){
        for (BySampleID sample : sampleIDList){
            if (sample.getSampleID().equals(sampleID) && sample.getDate(0).equals(date) && sample.getTime(0).equals(time)){
                return sample;
            }
        }
        BySampleID newSample = new BySampleID(sampleID);
        sampleIDList.add(newSample);
        return newSample;
    }
    public static List<ByAnalyte> getDataForSample(String sampleID) {
        for (BySampleID sample : sampleIDList) {
            if (sample.getSampleID().equals(sampleID)) {
                return sample.getAnalytes();
            }
        }
        return new ArrayList<>(); // Return an empty list if the sampleID is not found
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
    private static void printData(){
        for (BySampleID sample : sampleIDList){
            if (sample.getSampleID().matches("RINSE.*")){
                System.out.println("Sample ID: " + sample.getSampleID());
                for (ByAnalyte analyte : sample.getAnalytes()){
                    System.out.println(analyte);
                }
            }
        }
    }
    public static String pagePrinters(int option){
        String printLine = "\n";
        switch (option){
            case 1:
                printLine = StringHelpers.sampleBreak;
                break;
            case 2:
                printLine = StringHelpers.footer + "\n";
                break;
            case 3:
                printLine = StringHelpers.seperator;
                break;
        }
        return printLine;
    }
}