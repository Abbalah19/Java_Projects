package com.Reviewer.DataReviewer;

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

    public List<ByAnalyte> getAnalytes() {
        return analytes;
    }
}
