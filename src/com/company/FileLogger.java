package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileLogger implements ILogger {
    public FileLogger() {
        try {
            out = new PrintStream(new FileOutputStream("log.txt", true), true);
        } catch (FileNotFoundException exception) {
            out = null;
        }
    }
    public void Log (String message) {
        if (out != null)
            out.println(message);
        else {
            System.out.println("Logging to file failed!");
            System.exit(2412);
        }
    }

    private PrintStream out;
}