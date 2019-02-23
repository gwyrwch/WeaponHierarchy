package com.company;

public class LoggerFactory {
    public static ILogger CreaterLogger(int type) {
        if (type == 0)
            return new FileLogger();
        else if (type == 1)
            return new ConsoleLogger();
        return null;
    }
}