package com.Reviewer.DataReviewer;

public class NegativeReview {
    public String msgOver;

    public void negChecker(String analyteName, double reportedConc){
        String msg = "";
        String matrix = "";
        boolean isNegative = false;
        switch (analyteName){
            case "Ag":
                if (reportedConc < -0.25){
                    isNegative = true;
                    matrix = "all matrix";
                    break;
                }
                else if (reportedConc < -0.05){
                    isNegative = true;
                    matrix = "Soil/Water";
                    break;
                }
            case "Al":
                if (reportedConc < -2.5){
                    isNegative = true;
                    matrix = "all matrix";
                    break;
                }
                else if (reportedConc < -0.25){
                    isNegative = true;
                    matrix = "TCLP/Water";
                    break;
                }
            case "As": 
                if (reportedConc < -0.5){
                    isNegative = true;
                    matrix = "all matrix";
                    break;
                }
                else if (reportedConc < -0.25){
                    isNegative = true;
                    matrix = "TCLP";
                    break;
                }
                else if (reportedConc < -0.05){
                    isNegative = true;
                    matrix = "Water";
                    break;
                }
        }
        if (isNegative){
            msg += analyteName + " at " + reportedConc + "is too negative for " + matrix + " limits";
            setMsgOver(msg);
        }

    }

    public void setMsgOver(String msg){
        this.msgOver = msg;
    }
    public String getMsg(){
        return this.msgOver;
    }
}
