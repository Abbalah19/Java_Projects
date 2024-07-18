package com.Reviewer.DataReviewer;

public class StringHelpers {
    public static String sampleBreak = "==================================================================================\n";
    public static String footer =      "__________________________________________________________________________________\n";
    public static String seperator =   "----------------------------------------------------------------------------------\n";

    public static String getRandomMessage() {
        if (UI.getPassword().equals("AJ")) {
            String[] messages = {
                "You're doing great!",
                "Keep up the good work!",
                "You're awesome!",
                "Your effort doesn't go unnoticed!",
                "You're doing a great job!",
                "You're the best!",
                "shhhh... it's a secret program.",
                "You don't have to be crazy to work here, but it helps!",
                "The data is not late, the client is just early!",
                "Analyzing heavy metals: because 'light' metals are for amateurs.",
                "Our lab is like a heavy metal concert: lots of instruments and a rock-solid team.",
            };
            return messages[(int) (Math.random() * messages.length)];
        } else {
            return "Collecting data...";
        }
    }
}
