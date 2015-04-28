package com.training.admios;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class LoggerFactory {
    public static AbstractLogger getLogger(LoggerType type, String path) {
        AbstractLogger logger = null;
        switch(type) {
            case FILE:
                logger = new FileLogger(path);
                break;
            case ASYNC:
                logger = new AsyncLogger(path);
                break;
            case CONSOLE:
            default:
                logger = new ConsoleLogger();
                break;
        }

        return logger;
    }

    public static AbstractLogger getLogger(LoggerType type) {
        return LoggerFactory.getLogger(type, "");
    }
}
