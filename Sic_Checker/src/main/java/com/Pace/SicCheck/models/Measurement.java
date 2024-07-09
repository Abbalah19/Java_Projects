package com.Pace.SicCheck.models;

public class Measurement {
    final private String sampleId;
    final private String instrumentID;
    final private String date;
    final private String time;
    final private String analyteName;
    final private double reportedConc;

    public Measurement(String sampleId, String instrumentID, String date, String time, String analyteName,
            double reportedConc) {
        this.sampleId = sampleId;
        this.instrumentID = instrumentID;
        this.date = date;
        this.time = time;
        this.analyteName = analyteName;
        this.reportedConc = reportedConc;
    }

    public String getSampleId() {
        return sampleId;
    }

    public String getInstrumentID() {
        return instrumentID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAnalyteName() {
        return analyteName;
    }

    public double getReportedConc() {
        return reportedConc;
    }

    public Measurement getMeasurement(){
        return this;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "sampleId='" + sampleId + '\'' +
                ", instrumentID='" + instrumentID + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", element='" + analyteName + '\'' +
                ", value=" + reportedConc +
                '}';
    }
}