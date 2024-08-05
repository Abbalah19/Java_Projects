package com.secondeye;

public class CCV_Recovery {
    final private double Ag_trigger = 2.5;
    final private double Al_trigger = 10.0;
    final private double As_trigger = 5.0;
    final private double B_trigger = 5.0;
    final private double Ba_trigger = 5.0;
    final private double Be_trigger = 5.0;
    final private double Ca_trigger = 10.0;
    final private double Cd_trigger = 5.0;
    final private double Co_trigger = 5.0;
    final private double Cr_trigger = 5.0;
    final private double Cu_trigger = 5.0;
    final private double Fe_trigger = 5.0;
    final private double K_trigger = 10.0;
    final private double Mg_trigger = 10.0;
    final private double Mn_trigger = 5.0;
    final private double Mo_trigger = 5.0;
    final private double Na_trigger = 10.0;
    final private double Ni_trigger = 5.0;
    final private double Pb_trigger = 5.0;
    final private double Sb_trigger = 5.0;
    final private double Se_trigger = 5.0;
    final private double Sn_trigger = 5.0;
    final private double Ti_trigger = 5.0;
    final private double Tl_trigger = 2.5;
    final private double V_trigger = 5.0;
    final private double Zn_trigger = 5.0;
    final private double Zr_trigger = 5.0;
    private String message = "";


public void checkCCV(String metalName, double measuredValue) {
    boolean isFailure = false;
    String failMSG = "";

    switch (metalName) {
        case "Ag":
            if (measuredValue > Ag_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Ag Failed High. )\n";
            }
            else if (measuredValue < Ag_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Ag Failed Low. )\n";
            }
            break;
        case "Al":
            if (measuredValue > Al_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Al Failed High. )\n";
            }
            else if (measuredValue < Al_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Al Failed Low. )\n";
            }
            break;
        case "As":
            if (measuredValue > As_trigger * 1.1) {
                isFailure = true;
                failMSG = "( As Failed High. )\n";
            }
            else if (measuredValue < As_trigger * 0.9) {
                isFailure = true;
                failMSG = "( As Failed Low. )\n";
            }
            break;
        case "B":
            if (measuredValue > B_trigger * 1.1) {
                isFailure = true;
                failMSG = "( B Failed High. )\n";
            }
            else if (measuredValue < B_trigger * 0.9) {
                isFailure = true;
                failMSG = "( B Failed Low. )\n";
            }
            break;
        case "Ba":
            if (measuredValue > Ba_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Ba Failed High. )\n";
            }
            else if (measuredValue < Ba_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Ba Failed Low. )\n";
            }
            break;
        case "Be":
            if (measuredValue > Be_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Be Failed High. )\n";
            }
            else if (measuredValue < Be_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Be Failed Low. )\n";
            }
            break;
        case "Ca":
            if (measuredValue > Ca_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Ca Failed High. )\n";
            }
            else if (measuredValue < Ca_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Ca Failed Low. )\n";
            }
            break;
        case "Cd":
            if (measuredValue > Cd_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Cd Failed High. )\n";
            }
            else if (measuredValue < Cd_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Cd Failed Low. )\n";
            }
            break;
        case "Co":
            if (measuredValue > Co_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Co Failed High. )\n";
            }
            else if (measuredValue < Co_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Co Failed Low. )\n";
            }
            break;
        case "Cr":
            if (measuredValue > Cr_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Cr Failed High. )\n";
            }
            else if (measuredValue < Cr_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Cr Failed Low. )\n";
            }
            break;
        case "Cu":
            if (measuredValue > Cu_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Cu Failed High. )\n";
            }
            else if (measuredValue < Cu_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Cu Failed Low. )\n";
            }
            break;
        case "Fe":
            if (measuredValue > Fe_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Fe Failed High. )\n";
            }
            else if (measuredValue < Fe_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Fe Failed Low. )\n";
            }
            break;
        case "K":
            if (measuredValue > K_trigger * 1.1) {
                isFailure = true;
                failMSG = "( K Failed High. )\n";
            }
            else if (measuredValue < K_trigger * 0.9) {
                isFailure = true;
                failMSG = "( K Failed Low. )\n";
            }
            break;
        case "Mg":
            if (measuredValue > Mg_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Mg Failed High. )\n";
            }
            else if (measuredValue < Mg_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Mg Failed Low. )\n";
            }
            break;
        case "Mn":
            if (measuredValue > Mn_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Mn Failed High. )\n";
            }
            else if (measuredValue < Mn_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Mn Failed Low. )\n";
            }
            break;
        case "Mo":
            if (measuredValue > Mo_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Mo Failed High. )\n";
            }
            else if (measuredValue < Mo_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Mo Failed Low. )\n";
            }
            break;
        case "Na":
            if (measuredValue > Na_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Na Failed High. )\n";
            }
            else if (measuredValue < Na_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Na Failed Low. )\n";
            }
            break;
        case "Ni":
            if (measuredValue > Ni_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Ni Failed High. )\n";
            }
            else if (measuredValue < Ni_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Ni Failed Low. )\n";
            }
            break;
        case "Pb":
            if (measuredValue > Pb_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Pb Failed High. )\n";
            }
            else if (measuredValue < Pb_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Pb Failed Low. )\n";
            }
            break;
        case "Sb":
            if (measuredValue > Sb_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Sb Failed High. )\n";
            }
            else if (measuredValue < Sb_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Sb Failed Low. )\n";
            }
            break;
        case "Se":
            if (measuredValue > Se_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Se Failed High. )\n";
            }
            else if (measuredValue < Se_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Se Failed Low. )\n";
            }
            break;
        case "Sn":
            if (measuredValue > Sn_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Sn Failed High. )\n";
            }
            else if (measuredValue < Sn_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Sn Failed Low. )\n";
            }
            break;
        case "Ti":
            if (measuredValue > Ti_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Ti Failed High. )\n";
            }
            else if (measuredValue < Ti_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Ti Failed Low. )\n";
            }
            break;
        case "Tl":
            if (measuredValue > Tl_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Tl Failed High. )\n";
            }
            else if (measuredValue < Tl_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Tl Failed Low. )\n";
            }
            break;
        case "V":
            if (measuredValue > V_trigger * 1.1) {
                isFailure = true;
                failMSG = "( V Failed High. )\n";
            }
            else if (measuredValue < V_trigger * 0.9) {
                isFailure = true;
                failMSG = "( V Failed Low. )\n";
            }
            break;
        case "Zn":
            if (measuredValue > Zn_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Zn Failed High. )\n";
            }
            else if (measuredValue < Zn_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Zn Failed Low. )\n";
            }
            break;
        case "Zr":
            if (measuredValue > Zr_trigger * 1.1) {
                isFailure = true;
                failMSG = "( Zr Failed High. )\n";
            }
            else if (measuredValue < Zr_trigger * 0.9) {
                isFailure = true;
                failMSG = "( Zr Failed Low. )\n";
            }
            break;
        }
        if (isFailure) {
            message += failMSG;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}