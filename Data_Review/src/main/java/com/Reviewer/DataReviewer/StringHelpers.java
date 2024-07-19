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
                "You don't have to be crazy to work here, \nbut it helps!",
                "Analyzing heavy metals: because 'light' \nmetals are for amateurs.",
                "Our lab is like a heavy metal concert: \nlots of instruments and a rock-solid team.",
                "Don't look now, Nexion is watching!",
                "Quiet! The instruments can hear you.",
            };
            return messages[(int) (Math.random() * messages.length)];
        }
        if (UI.getPassword().equals("JLC")){
            String[] messages = {
                "You're doing great!",
                "Manage with an iron fist",
                "You're awesome!",
                "Your effort doesn't go unnoticed... \nwell, your staff notices it, at least!",
                "You're doing a great job!",
                "You're the best manager ever!",
                "shhhh... it's a secret program. Don't tell Noah!\n ( I haven't made him any messages yet!)",
                "You don't have to be crazy to work here, but it helps!",
                "The data is not late, the client is just early!",
                "Our lab is like a heavy metal concert: lots of \ninstruments and a rock-solid team.",
                "Wanna take bets on how many times the client will \nchange their mind?",
                "Do you think we will ever get our new machines?",
                "Lets get new jobs before the audit!",
            };
            return messages[(int) (Math.random() * messages.length)];
        } else {
            return "Collecting data...";
        }
    }
}
