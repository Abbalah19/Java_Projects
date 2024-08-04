package com.secondeye;

public class StringHelpers {

    public static String helpAbout = " ~ SecondEye V1.0 ~\n\nSecondEye is a software application that allows users to"+
        " review data and perform lab calculations. It is in development, so do not trust its results"+
        " without verifying them yourself.\n\nThis is not a replacement for traditional review practices"+
        " and should only be used as a tool to assist already trained reviewers in the review process.\n\n"+
        "This is version 1.0 and is the first to support a relational database, a user login system, and"+
        " user roles. I have never tried to make a program that needs to support concurrent users before,"+
        " so let's see how it goes.\n\nAJ, you have special permissions to test out new components before I"+
        " whitelist them for general use. Please let me know if you find any bugs or have any suggestions.";

    public static String helpDataReview = " ~ Data Review ~\n\nData Review contains features that are used to review data.\n\n" +
        "The data review options are a repurposed version of my first program. It will ask you to pick which instrument" +
        " you are reviewing data for, and then it will open a window allowing you to pick the source file, the destination" +
        " location, and what options you would like to use.\n\nThe options for ICP-OES are:\nSic-Check - Goes through the" +
        " data and checks SAMPLES (not instrument QC) for any values that are outside of the expected IEC range. If it detects" +
        " an exceedance, it will add the failure and what the interferences are to the report. Bear in mind these limits" +
        " change every six months or so as we do IEC studies, so check the update time on the report.\n\nInclude CCV & CCB" +
        " - This will include the CCV and CCB data in the report. This is not available for all options such as Sic-Check" +
        " on the grounds that if it is above the IEC limit, the QC failed anyway.\nCurrently, the CCV can be checked for:\n" +
        " - Over/Under 10% range\n - RPD (over 5%)\n - Y recovery (50-150%)\nThe CCB can be checked for:\n" +
        " - Being too negative or too high; this does consider matrix-specific reporting limits.\n - Y recovery (50-150%)\n\n" +
        "Negative Check - This will check SAMPLE data for any value that is worse than negative five times the reporting" +
        " limit and does take into account the matrix-specific reporting limits.\n\nInternal Standard - This will check" +
        " the internal standard recovery for all samples. It will check Y recovery to ensure it is between 50-150% recovery." +
        " It will check both the Axial and Radial recovery.\n\nJust check the boxes you want to include on the report, supply" +
        " the input file and output file, and click generate report.\n\n\nStill in the works:\n - Sort out the encoding for ICP4\n" +
        " - Add the ability to check for being over HCV range\n - Add Hg and MS options\n - *Integrate Sic-Check to a database*";
    

    public static String helpLabCalculations = " ~ Lab Calculations ~\n\nLab Calculations contains simple equations to help" +
        " with basic lab work. It will allow you to calculate:\n\n - Percent Recovery\n - Standard Dilutions\n - Sample Dilutions\n" +
        " This is probably the easiest thing for me to add too, so let me know if you have any other calculations you would like." +
        " More information on specific calculations can be found on the respective calculations page.";
    

    public static String helpDevOptions = " ~ Dev Options ~\n\nDev Options contains features that are" +
        " either for account management or are not ready for general use. Basically, only AJ and I should" +
        " be able to access this menu. (AJ, you shouldn't be able to add or delete accounts, but you can" +
        " change passwords and see the user table.)";
    

    }
