package com.secondeye;

import java.util.ArrayList;
import java.util.List;

public class BySampleID {
    private String sampleID;
    private List<ByAnalyte> analytes = new ArrayList<>();

    public BySampleID(String sampleID) {
        this.sampleID = sampleID;
    }

    public void addAnalyte(ByAnalyte analyte) {
        this.analytes.add(analyte);
    }

    public String getSampleID() {
        return sampleID;
    }

    public String getDate(int x) {
        return analytes.get(x).getDate();
    }

    public String getTime(int x) {
        return analytes.get(x).getTime();
    }

    public String getInsturmentID(int x) {
        return analytes.get(x).getInsturmentID();
    }

    public List<ByAnalyte> getAnalytes() {
        return analytes;
    }
}