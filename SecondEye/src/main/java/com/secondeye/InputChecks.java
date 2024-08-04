package com.secondeye;

public class InputChecks {
    public static String sanitizeInput(String input) {
        if (input != null) {
            // Trim leading and trailing whitespace
            input = input.trim();
            // Remove any special characters (example: only allow alphanumeric characters)
            input = input.replaceAll("[^a-zA-Z0-9]", "");
        }
        return input;
    }
}