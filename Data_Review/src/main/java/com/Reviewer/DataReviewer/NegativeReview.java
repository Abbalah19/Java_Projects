package com.Reviewer.DataReviewer;

import com.Reviewer.DataReviewer.ReportingLevelMap.ThresholdMatrixPair;
import java.util.Map;

public class NegativeReview {
    public String msgOver = "";

    public void negChecker(String analyteName, double reportedConc){
        String msg = "";
        boolean isNegative = false;

        Map<String, ThresholdMatrixPair[]> thresholdMap = ReportingLevelMap.getThresholdMap();
        ThresholdMatrixPair[] thresholds = thresholdMap.get(analyteName);

        if (thresholds != null) {
            for (ThresholdMatrixPair pair : thresholds) {
                if (reportedConc <= -5 * pair.threshold) {
                    isNegative = true;
                    msg += analyteName + " at " + reportedConc + " is too negative for " + pair.matrix + " limits\n";
                }
            }
        }

        if (isNegative){
            setMsgOver(msg);
        }
    }

    public void setMsgOver(String msg) {
        this.msgOver = msg;
    }

    public String getMsg() {
        return msgOver;
    }
}
