package com.training.admios;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class LoggerFactory {
    public static AbstractLogger getLogger(String type, String path) {
        switch(type) {
            case "file":
                return new FileLogger(path);
            case "async":
                return new AsyncLogger(path);
            case "console":
                return new ConsoleLogger();
            default:
                return new ConsoleLogger();
        }
    }

    public static AbstractLogger getLogger(String type) {
        return LoggerFactory.getLogger(type, "");
    }
}
