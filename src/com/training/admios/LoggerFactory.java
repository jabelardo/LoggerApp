package com.training.admios;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class LoggerFactory {
    public static AbstractLogger getConsoleLogger() {
        return new ConsoleLogger();
    }

    public static AbstractLogger getFileLogger(String path) {
        return new FileLogger(path);
    }

    public static AbstractLogger getAsyncLogger(String path){
        return new AsyncLogger(path);
    }
}
