package com.training.admios;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class LoggerManager {

    private LogLevel currentlLevel;
    private ArrayList<AbstractLogger> loggers;

    public LoggerManager() {
        this.loggers = new ArrayList<AbstractLogger>();
        this.currentlLevel = LogLevel.INFO;
    }

    public LoggerManager(LogLevel level) {
        this.loggers = new ArrayList<AbstractLogger>();
        this.currentlLevel = level;
    }

    public int size() {
        return loggers.size();
    }

    public boolean add(AbstractLogger abstractLogger) {
        return loggers.add(abstractLogger);
    }

    public boolean remove(Object o) {
        return loggers.remove(o);
    }

    public AbstractLogger remove(int index) {
        return loggers.remove(index);
    }

    public boolean removeAll(Collection<?> c) {
        return loggers.removeAll(c);
    }

    public LogLevel getCurrentLevel() {
        return currentlLevel;
    }

    public void setCurrentLevel(LogLevel currentlLevel) {
        this.currentlLevel = currentlLevel;
    }

    public void log(String message, LogLevel logLevel) {
        if(this.isLoggable(logLevel)) {
            for(AbstractLogger logger : loggers) {
                logger.log(message, logLevel);
            }
        }
    }

    private boolean isLoggable(LogLevel logLevel) {
        return this.currentlLevel.compareTo(logLevel) <= 0;
    }

    void info(String message) {
        this.log(message, LogLevel.INFO);
    }

    void debug(String message) {
        this.log(message, LogLevel.DEBUG);
    }

    void warning(String message) {
        this.log(message, LogLevel.WARNING);
    }

    void error(String message) {
        this.log(message, LogLevel.ERROR);
    }
}
