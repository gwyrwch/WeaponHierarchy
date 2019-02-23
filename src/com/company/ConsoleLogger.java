package com.company;

public class ConsoleLogger implements ILogger {
    public void Log (String message) {
        System.out.println(message);
    }
}