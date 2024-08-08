package com.secondeye;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.apache.tika.parser.txt.CharsetDetector;
import org.apache.tika.parser.txt.CharsetMatch;

public class EncodingDetection {

    public static String detectEncoding(String filePath) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            CharsetDetector detector = new CharsetDetector();
            detector.setText(bis);
            CharsetMatch match = detector.detect();
            return match.getName();
        }
    }

    public static String convertToUTF8IfNeeded(String inputFilePath) throws IOException {
        String detectedEncoding = detectEncoding(inputFilePath);
        if (!detectedEncoding.equalsIgnoreCase(StandardCharsets.UTF_8.name())) {
            String tempFilePath = "Temp.txt";
            convertToUTF8(inputFilePath, tempFilePath, detectedEncoding);
            return tempFilePath;
        }
        return inputFilePath;
    }

    public static void convertToUTF8(String inputFilePath, String outputFilePath, String sourceEncoding) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), sourceEncoding));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}