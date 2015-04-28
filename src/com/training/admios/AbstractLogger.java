package com.training.admios;

import java.util.Calendar;
import java.util.Formatter;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public abstract class AbstractLogger {

    private LogLevel currentLevel;

    abstract protected void logImp(String message, LogLevel level);

    public void log(String message, LogLevel level) {
        if(isLoggable(level)) {
            this.logImp(message, level);
        }
    }

    String getFormatedMessage(String message, LogLevel level) {
        return String.format("%s : %s",level, message);
    }

    public LogLevel getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(LogLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    private boolean isLoggable(LogLevel logLevel) {
        return this.getCurrentLevel().compareTo(logLevel) <= 0;
    }
}
