package com.Reviewer.DataReviewer;

public class ICP3_Sic {
    final private double Ag_trigger = 5.0;
    final private double Al_trigger = 500.0;
    final private double As_trigger = 100.0;
    final private double B_trigger = 50.0;
    final private double Ba_trigger = 100.0;
    final private double Be_trigger = 50.0;
    final private double Ca_trigger = 500.0;
    final private double Cd_trigger = 50.0;
    final private double Co_trigger = 100.0;
    final private double Cr_trigger = 100.0;
    final private double Cu_trigger = 100.0;
    final private double Fe_trigger = 500.0;
    final private double K_trigger = 500.0;
    final private double Mg_trigger = 200.0;
    final private double Mn_trigger = 100.0;
    final private double Mo_trigger = 100.0;
    final private double Na_trigger = 500.0;
    final private double Ni_trigger = 100.0;
    final private double Pb_trigger = 100.0;
    final private double Sb_trigger = 100.0;
    final private double Se_trigger = 200.0;
    final private double Sn_trigger = 10.0;
    final private double Ti_trigger = 100.0;
    final private double Tl_trigger = 100.0;
    final private double V_trigger = 100.0;
    final private double Zn_trigger = 20.0;
    final private double Zr_trigger = 100.0;
    private String message = "";

    public void checkAndBuildMessage(String metalName, double measuredValue) {
        boolean isInterference = false;
        String interferenceMessage = "";

        switch (metalName) {
            case "Ag":
                if (measuredValue > Ag_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ag SIC Interferes with: Zn. )\n";
                }
                break;
            case "Al":
                if (measuredValue > Al_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Al SIC Interferes with: Fe, Pb, Se, Tl, Zn )\n";
                }
                break;
            case "As":
                if (measuredValue > As_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( As SIC Interferes with: Cd, Tl )\n";
                }
                break;
            case "B":
                if (measuredValue > B_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( B SIC Interferes with: As, Tl )\n";
                }
                break;
            case "Ba":
                if (measuredValue > Ba_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ba SIC Interferes with: As, Co, Tl )\n";
                }
                break;
            case "Be":
                if (measuredValue > Be_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Be SIC Interferes with: N/A )\n";
                }
                break;
            case "Ca":
                if (measuredValue > Ca_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ca SIC Interferes with: Al, Mg, Mo, Pb, Se, Sn, Tl )\n";
                }
                break;
            case "Cd":
                if (measuredValue > Cd_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Cd SIC Interferes with: Tl )\n";
                }
                break;
            case "Co":
                if (measuredValue > Co_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Co SIC Interferes with: Al, As, Cd, Cu, Fe, Ni, Pb, Se )\n";
                }
                break;
            case "Cr":
                if (measuredValue > Cr_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Cr SIC Interferes with: As, Co, Mo, Pb, Sb, Tl, V, Zn )\n";
                }
                break;
            case "Cu":
                if (measuredValue > Cu_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Cu SIC Interferes with: Pb )\n";
                }
                break;
            case "Fe":
                if (measuredValue > Fe_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Fe SIC Interferes with: Ag, Al, As, Ba, Ca, Cr, Cu, Mg, Mn, Mo, Pb, Sb, Se, Tl, V, Zn )\n";
                }
                break;
            case "K":
                if (measuredValue > K_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( K SIC Interferes with: N/A)\n";
                }
                break;
            case "Mg":
                if (measuredValue > Mg_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Mg SIC Interferes with: Sn, V )\n";
                }
                break;
            case "Mn":
                if (measuredValue > Mn_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Mn SIC Interferes with: Ag, As, Cr, Ni, Pb, Se )\n";
                }
                break;
            case "Mo":
                if (measuredValue > Mo_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Mo SIC Interferes with: Al, As, B, Be, Co, Ni, Pb, Sb, V )\n";
                }
                break;
            case "Na":
                if (measuredValue > Na_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Na SIC Interferes with: Zn )\n";
                }
                break;
            case "Ni":
                if (measuredValue > Ni_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ni SIC Interferes with: Co, Pb, Tl )\n";
                }
                break;
            case "Pb":
                if (measuredValue > Pb_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Pb SIC Interferes with: N/A )\n";
                }
                break;
            case "Sb":
                if (measuredValue > Sb_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Sb SIC Interferes with: As, Ni, Tl )\n";
                }
                break;
            case "Se":
                if (measuredValue > Se_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Se SIC Interferes with: Sb, Tl)\n";
                }
                break;
            case "Sn":
                if (measuredValue > Sn_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Sn SIC Interferes with: Sb )\n";
                }
                break;
            case "Ti":
                if (measuredValue > Ti_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ti SIC Interferes with: As, Co, Cu, Pb, Sb, Tl )\n";
                }
                break;
            case "Tl":
                if (measuredValue > Tl_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Tl SIC Interferes with: Ni )\n";
                }
                break;
            case "V":
                if (measuredValue > V_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( V SIC Interferes with: Ag, As, Ba, Be, Cd, Cr, Cu, Mg, Mn, Sb, Se, Tl )\n";
                }
                break;
            case "Zn":
                if (measuredValue > Zn_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Zn SIC Interferes with: N/A )\n";
                }
                break;
            case "Zr":
                if (measuredValue > Zr_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Zr SIC Interferes with: N/A )\n";
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
