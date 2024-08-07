package com.secondeye;

public class StringHelpers {

    public static String newSample = "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Sample >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
    public static String seperator = "---------------------------------------------------------------------------------------";

    public static String patchNotes = " ~ Version 1.3 ~\n" +
        " - Added this record to track changes.\n" +
        " - Allowed admins to create new accounts.\n" +
        " - Removed the ability to create dev accounts.\n" +
        " - Fixed issue with file path not being stored when user pressed [Review Data] button; now" +
        "   the user can press the button back-to-back and the report will generate.\n" +
        " - Changed how the last updated String is stored in SIC checks and fixed the passing message" +
        "   for SIC checks.\n" +
        " - Separated methods for updating passwords and first-time login password changes; now it" +
        "   properly tracks when users need to change their passwords.\n" +
        " - Changed some spacing on review strings, especially for SIC check results.\n" +
        " - Excluded batch QC samples (Blank, BS, BSD, MS, DUP, PS) from SIC checks.\n" +
        " - Added pop-up message for exporting results to a text file.\n" +
        " - Changed the apache dependencies to only use the parser-text-module (shrunk jar size by nearly 40,000kb).\n";

    
    public static String helpAbout = " ~ SecondEye V1.3 ~\n\nSecondEye is a software application that allows users to"+
        " review data and perform lab calculations. It is in development, so do not trust its results"+
        " without verifying them yourself.\n\nThis is not a replacement for traditional review practices"+
        " and should only be used as a tool to assist already trained reviewers in the review process.\n\n"+
        "This is version 1.3 and supports a relational database, a user login system, and"+
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
        " the input file and output file, and click generate report.\n\n\nStill in the works:\n" +
        " - Add the ability to check for being over HCV range\n - Add Hg and MS options\n - *Integrate Sic-Check to a database*"+
        " - TESTING TESTING TESTING\n\n";    

    public static String helpLabCalculations = " ~ Lab Calculations (Coming Soon) ~\n\n ";
    

    public static String helpDevOptions = " ~ Dev Options ~\n\nDev Options contains features that are" +
        " for account management. Basically, only AJ and I should be able to access this menu. (AJ, you" +
        " shouldn't be able to delete accounts, but you can create new accounts, change passwords and see" +
        " the user table.)";
    
    public static String DEV_NOTES =  "Notes to Self:\n" +
        "Right now the user input is sanatized and removes special characters. This is a slight security"+
        " concern for passwords. Eventually switch over to Argon2 and salt them. Until then it's good enough\n\n"+
    
        "The current program uses a lot of string matching to identify what sample is being checked and" +
        " position matching from the PRN file to identify what data from that sample is being checked." +
        " Changes to IDs or changes to data manager templates will break things. In most cases, it will" +
        " be a simple fix, though.\n\n" +
    
        "- Negative value check has been reworked to use a map from the ReportingLevelMap class to check the data." +
        " This should help with checks like CCB and calibration. I really should change the SIC check" +
        " values to use a map system as well... It would turn three separate classes into one...\n\n" +
    
        "- The current PRN file format does not include the data to calculate REs or R2 values. Trying to add it" +
        " too the format might break how it is read for element. This may not be a problem on the new system," +
        " but for now......\n\n" +
    
        "- The current structure scans through a PRN file and builds an ArrayList object from each row. A " +
        "second iteration over the list groups the data objects into another ArrayList based on the " +
        "sample ID and time. This isn't exactly efficient, but we might make up time for actions that " +
        "have to scan back and forth through the data. We'll see.\n\n" +
    
        "- The objects created for the inner list actually collect more data than is currently used. This " +
        "is because I might want to add more checks in the future, and I don't want to modify my class.\n\n";
    
    }
