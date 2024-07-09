package com.Pace.SicCheck.models;

public class CCV {
    private String message = " ";

    public void checkAndBuildMessage(String metalName, double measuredValue) {
        boolean isCCVFail = false;
        String CCVMessage = "";

        switch (metalName) {
            case "Ag":
                if (measuredValue > 2.75) {
                    isCCVFail = true;
                    CCVMessage = "( Ag High. )\n";
                }
                if (measuredValue < 2.25) {
                    isCCVFail = true;
                    CCVMessage = "( Ag Low. )\n";
                }
                break;
            case "Al":
                if (measuredValue > 11.0) {
                    isCCVFail = true;
                    CCVMessage = "( Al High. )\n";
                }
                if (measuredValue < 9.0) {
                    isCCVFail = true;
                    CCVMessage = "( Al Low. )\n";
                }
                break;
            case "As":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( As High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( As Low. )\n";
                }
                break;
            case "B":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( B High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( B Low. )\n";
                }
                break;
            case "Ba":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Ba High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Ba Low. )\n";
                }
                break;
            case "Be":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Be High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Be Low. )\n";
                }
                break;
            case "Ca":
            if (measuredValue > 11.0) {
                isCCVFail = true;
                CCVMessage = "( Ca High. )\n";
            }
            if (measuredValue < 9.0) {
                isCCVFail = true;
                CCVMessage = "( Ca Low. )\n";
            }
                break;
            case "Cd":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Cd High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Cd Low. )\n";
                }
                break;
            case "Co":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Co High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Co Low. )\n";
                }
                break;
            case "Cr":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Cr High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Cr Low. )\n";
                }
                break;
            case "Cu":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Cu High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Cu Low. )\n";
                }
                break;
            case "Fe":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Fe High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Fe Low. )\n";
                }
                break;
            case "K":
                if (measuredValue > 11.0) {
                    isCCVFail = true;
                    CCVMessage = "( K High. )\n";
                }
                if (measuredValue < 9.0) {
                    isCCVFail = true;
                    CCVMessage = "( K Low. )\n";
                }
                break;
            case "Mg":
                if (measuredValue > 11.0) {
                    isCCVFail = true;
                    CCVMessage = "( Mg High. )\n";
                }
                if (measuredValue < 9.0) {
                    isCCVFail = true;
                    CCVMessage = "( Mg Low. )\n";
                }
                break;
            case "Mn":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Mn High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Mn Low. )\n";
                }
                break;
            case "Mo":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Mo High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Mo Low. )\n";
                }
                break;
            case "Na":
                if (measuredValue > 11.0) {
                    isCCVFail = true;
                    CCVMessage = "( Na High. )\n";
                }
                if (measuredValue < 9.0) {
                    isCCVFail = true;
                    CCVMessage = "( Na Low. )\n";
                }
                break;
            case "Ni":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Ni High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Ni Low. )\n";
                }
                break;
            case "Pb":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Pb High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Pb Low. )\n";
                }
                break;
            case "Sb":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Sb High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Sb Low. )\n";
                }
                break;
            case "Se":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Se High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Se Low. )\n";
                }
                break;
            case "Sn":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Sn High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Sn Low. )\n";
                }
                break;
            case "Ti":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Ti High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Ti Low. )\n";
                }
                break;
            case "Tl":
                if (measuredValue > 2.25) {
                    isCCVFail = true;
                    CCVMessage = "( Tl High. )\n";
                }
                if (measuredValue < 2.75) {
                    isCCVFail = true;
                    CCVMessage = "( Tl Low. )\n";
                }
                break;
            case "V":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( V High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( V Low. )\n";
                }
                break;
            case "Zn":
                if (measuredValue > 5.5) {
                    isCCVFail = true;
                    CCVMessage = "( Zn High. )\n";
                }
                if (measuredValue < 4.5) {
                    isCCVFail = true;
                    CCVMessage = "( Zn Low. )\n";
                }
                break;
        }

        if (isCCVFail) {
            message += CCVMessage;
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
