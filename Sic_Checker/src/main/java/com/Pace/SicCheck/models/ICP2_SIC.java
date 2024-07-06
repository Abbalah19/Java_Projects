package com.Pace.SicCheck.models;

public class ICP2_SIC {
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
        String interferenceMessage = "";

        switch (metalName) {
            case "Ag":
                if (measuredValue > Ag_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Ag SIC Interferes with: Zn. ) ";
                }
                break;
            case "Al":
                if (measuredValue > Al_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Al SIC Interferes with: Pb ) ";
                }
                break;
            case "As":
                if (measuredValue > As_trigger) {
                    isInterference = true;
                    interferenceMessage = "( As SIC Interferes with: Cd ) ";
                }
                break;
            case "B":
                if (measuredValue > B_trigger) {
                    isInterference = true;
                    interferenceMessage = "( B SIC Interferes with: As ) ";
                }
                break;
            case "Ba":
                if (measuredValue > Ba_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Ba SIC Interferes with: As, Co ) ";
                }
                break;
            case "Be":
                if (measuredValue > Be_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Be SIC Interferes with: N/A ) ";
                }
                break;
            case "Ca":
                if (measuredValue > Ca_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Ca SIC Interferes with: As, Mg, Se ) ";
                }
                break;
            case "Cd":
                if (measuredValue > Cd_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Cd SIC Interferes with: Cr ) ";
                }
                break;
            case "Co":
                if (measuredValue > Co_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Co SIC Interferes with: Al, As, Cd, Fe, Ni, Pb ) ";
                }
                break;
            case "Cr":
                if (measuredValue > Cr_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Cr SIC Interferes with: As Co, Mg, Pb, Sb Zn )";
                }
                break;
            case "Cu":
                if (measuredValue > Cu_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Cu SIC Interferes with: Pb ) ";
                }
                break;
            case "Fe":
                if (measuredValue > Fe_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Fe SIC Interferes with: Ag, Al, As, Ba, Cd, Mg, Mn, Pb, Sb, Se, Tl, V, Zn, Zr ) ";
                }
                break;
            case "K":
                if (measuredValue > K_trigger) {
                    isInterference = true;
                    interferenceMessage = "( K SIC Interferes with: N/A) ";
                }
                break;
            case "Mg":
                if (measuredValue > Mg_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Mg SIC Interferes with: Se) ";
                }
                break;
            case "Mn":
                if (measuredValue > Mn_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Mn SIC Interferes with: Ag, Cr, Pb, Se ) ";
                }
                break;
            case "Mo":
                if (measuredValue > Mo_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Mo SIC Interferes with: Ag, Al, As, B, Ba, Be, Cd, Ca, Pb, Sb, Se, V ) ";
                }
                break;
            case "Na":
                if (measuredValue > Na_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Na SIC Interferes with: Zn ) ";
                }
                break;
            case "Ni":
                if (measuredValue > Ni_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Ni SIC Interferes with: Cd, Co Pb )";
                }
                break;
            case "Pb":
                if (measuredValue > Pb_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Pb SIC Interferes with: N/A ) ";
                }
                break;
            case "Sb":
                if (measuredValue > Sb_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Sb SIC Interferes with: As, Ni, Se )";
                }
                break;
            case "Se":
                if (measuredValue > Se_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Se SIC Interferes with: Sb ) ";
                }
                break;
            case "Sn":
                if (measuredValue > Sn_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Sn SIC Interferes with: Sb ) ";
                }
                break;
            case "Ti":
                if (measuredValue > Ti_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Ti SIC Interferes with: As, Cd, Co, Pb, Tl, V ) ";
                }
                break;
            case "Tl":
                if (measuredValue > Tl_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Tl SIC Interferes with: Ni ) ";
                }
                break;
            case "V":
                if (measuredValue > V_trigger) {
                    isInterference = true;
                    interferenceMessage = "( V SIC Interferes with: Ag, As, Ba, Be, Cd, Cr, Mg, Sb, Tl ) ";
                }
                break;
            case "Zn":
                if (measuredValue > Zn_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Zn SIC Interferes with: N/A ) ";
                }
                break;
            case "Zr":
                if (measuredValue > Zr_trigger) {
                    isInterference = true;
                    interferenceMessage = "( Zr SIC Interferes with: Ag, Al, Cr, Cu, Fe, Mg, Pb, Sb, Se, Sn, Ti, Tl, Zn ) ";
                }
                break;
        }

        if (isInterference) {
            message += interferenceMessage;
            setMessage(message);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }
}