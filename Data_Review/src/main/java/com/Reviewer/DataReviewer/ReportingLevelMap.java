package com.Reviewer.DataReviewer;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReportingLevelMap {
    private static final Map<String, ThresholdMatrixPair[]> thresholdMap = new LinkedHashMap<>();

    static {
        thresholdMap.put("Ag", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.01),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 0.05),
            new ThresholdMatrixPair("Air", 0.05),
        });
        
        thresholdMap.put("Al", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.05),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.5),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", -1),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("As", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.1),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 0.05),
            new ThresholdMatrixPair("Air", 0.05),
        });
    }

    // Define the ThresholdMatrixPair class
    private static class ThresholdMatrixPair {
        String matrix;
        double threshold;

        public ThresholdMatrixPair(String matrix, double threshold) {
            this.matrix = matrix;
            this.threshold = threshold;
        }
    }
}
