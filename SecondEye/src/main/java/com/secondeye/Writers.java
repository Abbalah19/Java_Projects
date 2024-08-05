package com.secondeye;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writers implements AutoCloseable {
    private PrintWriter printWriter;

    // Constructor with proper naming and no return type
    public Writers(String filePath, boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, append);
        this.printWriter = new PrintWriter(fileWriter);
    }

    public void writeLine(String line) {
        if (printWriter != null) {
            printWriter.println(line);
        }
    }

    @Override
    public void close() {
        if (printWriter != null) {
            printWriter.close();
        }
    }
}