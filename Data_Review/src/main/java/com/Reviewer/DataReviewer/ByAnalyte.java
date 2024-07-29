package com.Reviewer.DataReviewer;

public class ByAnalyte {
    final private String sampleID; // 0
    final private String userValue1; // 2 - ICP2, ICP3, ICP - 4
    final private String date; // 6
    final private String time; // 7
    final private String analyte_waveLength; // 8
    final private Double concSamp; // 9
    final private String elem; // 10
    final private Double wavelength; // 11
    final private Double concCalib; // 12
    final private Double reportedConc; // 13
    final private String calibUnits; // 14
    final private String sampUnits; // 15
    final private Double intCorr; // 16
    final private int repNumber1; // 17
    final private Double concCalib1; // 18
    final private Double concSamp1; // 19
    final private int repNumber2; // 20
    final private Double concCalib2; // 21
    final private Double concSamp2; // 22
    final private int repNumber3; // 23
    final private Double concCalib3; // 24
    final private Double concSamp3; // 25
    final private int repNumber4; // 26
    final private Double concCalib4; // 27
    final private Double concSamp4; // 28

    public ByAnalyte(String sampleID, String userValue1, String date, String time, String analyte_waveLength, 
        Double concSamp, String elem, Double wavelength, Double concCalib, Double reportedConc, String calibUnits, 
        String sampUnits, Double intCorr, int repNumber1, Double concCalib1, Double concSamp1, int repNumber2, 
        Double concCalib2, Double concSamp2, int repNumber3, Double concCalib3, Double concSamp3, int repNumber4, 
        Double concCalib4, Double concSamp4) {
            this.sampleID = sampleID;
            this.userValue1 = userValue1;
            this.date = date;
            this.time = time;
            this.analyte_waveLength = analyte_waveLength;
            this.concSamp = concSamp;
            this.elem = elem;
            this.wavelength = wavelength;
            this.concCalib = concCalib;
            this.reportedConc = reportedConc;
            this.calibUnits = calibUnits;
            this.sampUnits = sampUnits;
            this.intCorr = intCorr;
            this.repNumber1 = repNumber1;
            this.concCalib1 = concCalib1;
            this.concSamp1 = concSamp1;
            this.repNumber2 = repNumber2;
            this.concCalib2 = concCalib2;
            this.concSamp2 = concSamp2;
            this.repNumber3 = repNumber3;
            this.concCalib3 = concCalib3;
            this.concSamp3 = concSamp3;
            this.repNumber4 = repNumber4;
            this.concCalib4 = concCalib4;
            this.concSamp4 = concSamp4;
    } 

    public String getSampleID() {
        return sampleID;
    }

    public Double getReportedConc() {
        return reportedConc;
    }

    public String getElem() {
        return elem;
    }

    public String getInsturmentID() {
        return userValue1;
    }

    public String getAnalyteName() {
        return analyte_waveLength;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Double getConcCalib() {
        return concCalib;
    }

    @Override
    public String toString() {
        return "InnerList {" +
                "sampleId='" + sampleID + '\'' +
                ", instrumentID='" + userValue1 + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", element='" + elem + '\'' +
                ", value=" + reportedConc +
                '}';
    }
}