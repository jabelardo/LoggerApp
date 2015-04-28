package com.training.admios;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class LoggerFactory {
    public static AbstractLogger getLogger(LoggerType type,LogLevel level, String path) {
        AbstractLogger logger = null;
        switch(type) {
            case FILE:
                logger = new FileLogger(level, path);
                break;
            case ASYNC:
                logger = new AsyncLogger(new FileLogger(level, path));
                break;
            case CONSOLE:
            default:
                logger = new ConsoleLogger(level);
                break;
        }

        return logger;
    }

    public static AbstractLogger getLogger(LoggerType type, LogLevel level) {
        return LoggerFactory.getLogger(type, level, "");
    }
}
