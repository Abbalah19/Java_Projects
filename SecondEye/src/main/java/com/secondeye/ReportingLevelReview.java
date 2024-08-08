package com.secondeye;

import java.util.Map;

import com.secondeye.ReportingLevelMap.ThresholdMatrixPair;

public class ReportingLevelReview {
    public String msgOver = "";

    public void reportingLevelReview(String analyteName, double reportedConc) {
        String msg = "";
        boolean isHit = false;

        Map<String, ThresholdMatrixPair[]> thresholdMap = ReportingLevelMap.getThresholdMap();
        ThresholdMatrixPair[] thresholds = thresholdMap.get(analyteName);

        if (thresholds != null) {
            for (ThresholdMatrixPair pair : thresholds) {
                if (reportedConc > pair.threshold) {
                    isHit = true;
                    msg += analyteName + " at " + reportedConc + " is over RL for " + pair.matrix + "\n";
                }
            }
        }
        if (isHit){
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