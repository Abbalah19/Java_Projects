package com.Reviewer.DataReviewer;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReportingLevelMap {
    public static final Map<String, ThresholdMatrixPair[]> thresholdMap = new LinkedHashMap<>();

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
            new ThresholdMatrixPair("Paint", 1000),
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

        thresholdMap.put("B", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.1),
            new ThresholdMatrixPair("TCLP", 0.1),
            new ThresholdMatrixPair("Soil", 0.1),
            new ThresholdMatrixPair("Wipe", 1000),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 1000),
        });

        thresholdMap.put("Ba", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.05),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", .05),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 0.05),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Be", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.004),
            new ThresholdMatrixPair("TCLP", 0.004),
            new ThresholdMatrixPair("Soil", 0.005),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 0.05),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Ca", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.5),
            new ThresholdMatrixPair("TCLP", 1000),
            new ThresholdMatrixPair("Soil", 0.5),
            new ThresholdMatrixPair("Wipe", 0.5),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 1000),
        });

        thresholdMap.put("Cd", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.004),
            new ThresholdMatrixPair("TCLP", 0.01),
            new ThresholdMatrixPair("Soil", 0.01),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 0.05),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Co", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.05),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Cr", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.02),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 0.05),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Cu", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.01),
            new ThresholdMatrixPair("Soil", 0.02),
            new ThresholdMatrixPair("Wipe", 0.1),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.1),
        });

        thresholdMap.put("Fe", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.05),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.5),
            new ThresholdMatrixPair("Wipe", 1),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.4),
        });

        thresholdMap.put("K", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 2),
            new ThresholdMatrixPair("TCLP", 1000),
            new ThresholdMatrixPair("Soil", 5),
            new ThresholdMatrixPair("Wipe", 1000),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 1000),
        });

        thresholdMap.put("Mg", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.05),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.5),
            new ThresholdMatrixPair("Wipe", 0.5),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 1000),
        });

        thresholdMap.put("Mn", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.01),
            new ThresholdMatrixPair("Soil", 0.01),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Mo", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.05),
            new ThresholdMatrixPair("TCLP", 1000),
            new ThresholdMatrixPair("Soil", 0.1),
            new ThresholdMatrixPair("Wipe", 1000),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 1000),
        });

        thresholdMap.put("Na", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 2),
            new ThresholdMatrixPair("TCLP", 1000),
            new ThresholdMatrixPair("Soil", 5),
            new ThresholdMatrixPair("Wipe", 5),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 1000),
        });

        thresholdMap.put("Ni", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.01),
            new ThresholdMatrixPair("Soil", 0.02),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Pb", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.1),
            new ThresholdMatrixPair("Soil", 0.015),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 0.05),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Sb", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.05),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.05),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Se", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.05),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.1),
            new ThresholdMatrixPair("Wipe", 0.5),
            new ThresholdMatrixPair("Paint", 0.05),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Sn", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.1),
            new ThresholdMatrixPair("TCLP", 0.1),
            new ThresholdMatrixPair("Soil", 0.1),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 1000),
        });

        thresholdMap.put("Ti", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.02),
            new ThresholdMatrixPair("TCLP", 1000),
            new ThresholdMatrixPair("Soil", 0.1),
            new ThresholdMatrixPair("Wipe", 1000),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 1000),
        });

        thresholdMap.put("Tl", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.05),
            new ThresholdMatrixPair("TCLP", 0.05),
            new ThresholdMatrixPair("Soil", 0.05),
            new ThresholdMatrixPair("Wipe", 0.05),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("V", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.01),
            new ThresholdMatrixPair("Soil", 0.02),
            new ThresholdMatrixPair("Wipe", 1000),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.05),
        });

        thresholdMap.put("Zn", new ThresholdMatrixPair[]{
            new ThresholdMatrixPair("Water", 0.01),
            new ThresholdMatrixPair("TCLP", 0.5),
            new ThresholdMatrixPair("Soil", 0.02),
            new ThresholdMatrixPair("Wipe", 2),
            new ThresholdMatrixPair("Paint", 1000),
            new ThresholdMatrixPair("Air", 0.1),
        });
    }

    // Define the ThresholdMatrixPair class
    public static class ThresholdMatrixPair {
        String matrix;
        double threshold;

        public ThresholdMatrixPair(String matrix, double threshold) {
            this.matrix = matrix;
            this.threshold = threshold;
        }
    }

    public static Map<String, ThresholdMatrixPair[]> getThresholdMap() {
        return thresholdMap;
    }
}