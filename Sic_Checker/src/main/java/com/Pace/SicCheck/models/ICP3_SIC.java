package com.Pace.SicCheck.models;

public class ICP3_SIC {
    private double Ag_trigger = 100.0;
    private double Al_trigger = 500.0;
    private double As_trigger = 100.0;
    private double B_trigger = 200.0;
    private double Ba_trigger = 100.0;
    private double Be_trigger = 100.0;
    private double Ca_trigger = 100.0;
    private double Cd_trigger = 100.0;
    private double Co_trigger = 100.0;
    private double Cr_trigger = 100.0;
    private double Cu_trigger = 100.0;
    private double Fe_trigger = 100.0;
    private double K_trigger = 100.0;
    private double Mg_trigger = 100.0;
    private double Mn_trigger = 100.0;
    private double Mo_trigger = 100.0;
    private double Na_trigger = 100.0;
    private double Ni_trigger = 100.0;
    private double Pb_trigger = 100.0;
    private double Sb_trigger = 100.0;
    private double Se_trigger = 100.0;
    private double Sn_trigger = 100.0;
    private double Ti_trigger = 100.0;
    private double Tl_trigger = 100.0;
    private double V_trigger = 100.0;
    private double Zn_trigger = 100.0;
    private double Zr_trigger = 100.0;
    private String message = " ";

    public void checkAndBuildMessage(String metalName, double measuredValue) {
        boolean isInterference = false;
        String interferenceMessage = "default";

        switch (metalName) {
            case "Ag":
                if (measuredValue > Ag_trigger) {
                    isInterference = true;
                    interferenceMessage = "Ag exceeds trigger value.";
                }
                break;
            case "Al":
                if (measuredValue > Al_trigger) {
                    isInterference = true;
                    interferenceMessage = "Al exceeds trigger value.";
                }
                break;
            case "As":
                if (measuredValue > As_trigger) {
                    isInterference = true;
                    interferenceMessage = "As exceeds trigger value, causing interference with Tl.";
                }
                break;
            case "B":
                if (measuredValue > B_trigger) {
                    isInterference = true;
                    interferenceMessage = "B exceeds trigger value.";
                }
                break;
            case "Ba":
                if (measuredValue > Ba_trigger) {
                    isInterference = true;
                    interferenceMessage = "Ba exceeds trigger value.";
                }
                break;
            case "Be":
                if (measuredValue > Be_trigger) {
                    isInterference = true;
                    interferenceMessage = "Be exceeds trigger value.";
                }
                break;
            case "Ca":
                if (measuredValue > Ca_trigger) {
                    isInterference = true;
                    interferenceMessage = "Ca exceeds trigger value.";
                }
                break;
            case "Cd":
                if (measuredValue > Cd_trigger) {
                    isInterference = true;
                    interferenceMessage = "Cd exceeds trigger value.";
                }
                break;
            case "Co":
                if (measuredValue > Co_trigger) {
                    isInterference = true;
                    interferenceMessage = "Co exceeds trigger value.";
                }
                break;
            case "Cr":
                if (measuredValue > Cr_trigger) {
                    isInterference = true;
                    interferenceMessage = "Cr exceeds trigger value.";
                }
                break;
            case "Cu":
                if (measuredValue > Cu_trigger) {
                    isInterference = true;
                    interferenceMessage = "Cu exceeds trigger value.";
                }
                break;
            case "Fe":
                if (measuredValue > Fe_trigger) {
                    isInterference = true;
                    interferenceMessage = "Fe exceeds trigger value.";
                }
                break;
            case "K":
                if (measuredValue > K_trigger) {
                    isInterference = true;
                    interferenceMessage = "K exceeds trigger value.";
                }
                break;
            case "Mg":
                if (measuredValue > Mg_trigger) {
                    isInterference = true;
                    interferenceMessage = "Mg exceeds trigger value.";
                }
                break;
            case "Mn":
                if (measuredValue > Mn_trigger) {
                    isInterference = true;
                    interferenceMessage = "Mn exceeds trigger value.";
                }
                break;
            case "Mo":
                if (measuredValue > Mo_trigger) {
                    isInterference = true;
                    interferenceMessage = "Mo exceeds trigger value.";
                }
                break;
            case "Na":
                if (measuredValue > Na_trigger) {
                    isInterference = true;
                    interferenceMessage = "Na exceeds trigger value.";
                }
                break;
            case "Ni":
                if (measuredValue > Ni_trigger) {
                    isInterference = true;
                    interferenceMessage = "Ni exceeds trigger value.";
                }
                break;
            case "Pb":
                if (measuredValue > Pb_trigger) {
                    isInterference = true;
                    interferenceMessage = "Pb exceeds trigger value.";
                }
                break;
            case "Sb":
                if (measuredValue > Sb_trigger) {
                    isInterference = true;
                    interferenceMessage = "Sb exceeds trigger value.";
                }
                break;
            case "Se":
                if (measuredValue > Se_trigger) {
                    isInterference = true;
                    interferenceMessage = "Se exceeds trigger value.";
                }
                break;
            case "Sn":
                if (measuredValue > Sn_trigger) {
                    isInterference = true;
                    interferenceMessage = "Sn exceeds trigger value.";
                }
                break;
            case "Ti":
                if (measuredValue > Ti_trigger) {
                    isInterference = true;
                    interferenceMessage = "Ti exceeds trigger value.";
                }
                break;
            case "Tl":
                if (measuredValue > Tl_trigger) {
                    isInterference = true;
                    interferenceMessage = "Tl exceeds trigger value.";
                }
                break;
            case "V":
                if (measuredValue > V_trigger) {
                    isInterference = true;
                    interferenceMessage = "V exceeds trigger value.";
                }
                break;
            case "Zn":
                if (measuredValue > Zn_trigger) {
                    isInterference = true;
                    interferenceMessage = "Zn exceeds trigger value.";
                }
                break;
            case "Zr":
                if (measuredValue > Zr_trigger) {
                    isInterference = true;
                    interferenceMessage = "Zr exceeds trigger value.";
                }
                break;
        }

        if (isInterference) {
            message = interferenceMessage;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = "default";
    }
}