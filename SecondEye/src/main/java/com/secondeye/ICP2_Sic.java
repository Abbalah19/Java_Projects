package com.secondeye;

public class ICP2_Sic {
    private String message = "Last Updated: First Quarter 2024 ~\n";
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


    public void checkAndBuildMessage(String metalName, double measuredValue) {
        boolean isInterference = false;
        String interferenceMessage = "";

        switch (metalName) {
            case "Ag":
                if (measuredValue > Ag_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ag ( "+ measuredValue +" ) SIC Interferes with: Zn. )\n";
                }
                break;
            case "Al":
                if (measuredValue > Al_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Al ( "+ measuredValue +" ) SIC Interferes with: Pb )\n";
                }
                break;
            case "As":
                if (measuredValue > As_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( As ( "+ measuredValue +" ) SIC Interferes with: Cd )\n";
                }
                break;
            case "B":
                if (measuredValue > B_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( B ( "+ measuredValue +" ) SIC Interferes with: As )\n";
                }
                break;
            case "Ba":
                if (measuredValue > Ba_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ba ( "+ measuredValue +" ) SIC Interferes with: As, Co )\n";
                }
                break;
            case "Be":
                if (measuredValue > Be_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Be ( "+ measuredValue +" ) SIC Interferes with: N/A )\n";
                }
                break;
            case "Ca":
                if (measuredValue > Ca_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ca ( "+ measuredValue +" ) SIC Interferes with: As, Mg, Se )\n";
                }
                break;
            case "Cd":
                if (measuredValue > Cd_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Cd ( "+ measuredValue +" ) SIC Interferes with: Cr )\n";
                }
                break;
            case "Co":
                if (measuredValue > Co_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Co ( "+ measuredValue +" ) SIC Interferes with: Al, As, Cd, Fe, Ni, Pb )\n";
                }
                break;
            case "Cr":
                if (measuredValue > Cr_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Cr ( "+ measuredValue +" ) SIC Interferes with: As Co, Mg, Pb, Sb Zn )\n";
                }
                break;
            case "Cu":
                if (measuredValue > Cu_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Cu ( "+ measuredValue +" ) SIC Interferes with: Pb )\n";
                }
                break;
            case "Fe":
                if (measuredValue > Fe_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Fe ( "+ measuredValue +" ) SIC Interferes with: Ag, Al, As, Ba, Cd, Mg, Mn, Pb, Sb, Se, Tl, V, Zn, Zr )\n";
                }
                break;
            case "K":
                if (measuredValue > K_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( K ( "+ measuredValue +" ) SIC Interferes with: N/A)\n";
                }
                break;
            case "Mg":
                if (measuredValue > Mg_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Mg ( "+ measuredValue +" ) SIC Interferes with: Se)\n";
                }
                break;
            case "Mn":
                if (measuredValue > Mn_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Mn ( "+ measuredValue +" ) SIC Interferes with: Ag, Cr, Pb, Se )\n";
                }
                break;
            case "Mo":
                if (measuredValue > Mo_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Mo ( "+ measuredValue +" ) SIC Interferes with: Ag, Al, As, B, Ba, Be, Cd, Ca, Pb, Sb, Se, V )\n";
                }
                break;
            case "Na":
                if (measuredValue > Na_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Na ( "+ measuredValue +" ) SIC Interferes with: Zn )\n";
                }
                break;
            case "Ni":
                if (measuredValue > Ni_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ni ( "+ measuredValue +" ) SIC Interferes with: Cd, Co, Pb )\n";
                }
                break;
            case "Pb":
                if (measuredValue > Pb_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Pb ( "+ measuredValue +" ) SIC Interferes with: N/A )\n";
                }
                break;
            case "Sb":
                if (measuredValue > Sb_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Sb ( "+ measuredValue +" ) SIC Interferes with: As, Ni, Se )\n";
                }
                break;
            case "Se":
                if (measuredValue > Se_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Se ( "+ measuredValue +" ) SIC Interferes with: Sb )\n";
                }
                break;
            case "Sn":
                if (measuredValue > Sn_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Sn ( "+ measuredValue +" ) SIC Interferes with: Sb )\n";
                }
                break;
            case "Ti":
                if (measuredValue > Ti_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Ti ( "+ measuredValue +" ) SIC Interferes with: As, Cd, Co, Pb, Tl, V )\n";
                }
                break;
            case "Tl":
                if (measuredValue > Tl_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Tl ( "+ measuredValue +" ) SIC Interferes with: Ni )\n";
                }
                break;
            case "V":
                if (measuredValue > V_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( V ( "+ measuredValue +" ) SIC Interferes with: Ag, As, Ba, Be, Cd, Cr, Mg, Sb, Tl )\n";
                }
                break;
            case "Zn":
                if (measuredValue > Zn_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Zn ( "+ measuredValue +" ) SIC Interferes with: N/A )\n";
                }
                break;
            case "Zr":
                if (measuredValue > Zr_trigger || measuredValue == 0.0) {
                    isInterference = true;
                    interferenceMessage = "( Zr ( "+ measuredValue +" ) SIC Interferes with: Ag, Al, Cr, Cu, Fe, Mg, Pb, Sb, Se, Sn, Ti, Tl, Zn )\n";
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
