package com.training.admios;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class LoggerManager {

    private LogLevel actualLevel;
    private ArrayList<AbstractLogger> loggers;

    public LoggerManager() {
        this.loggers = new ArrayList<AbstractLogger>();
        this.actualLevel = LogLevel.INFO;
    }

    public LoggerManager(LogLevel level) {
        this.loggers = new ArrayList<AbstractLogger>();
        this.actualLevel = level;
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

    public LogLevel getActualLevel() {
        return actualLevel;
    }

    public void setActualLevel(LogLevel actualLevel) {
        this.actualLevel = actualLevel;
    }

    public void log(String message, LogLevel logLevel) {
        if(this.isLoggable(logLevel)) {
            for(AbstractLogger logger : loggers) {
                logger.log(message, logLevel);
            }
        }
    }

    private boolean isLoggable(LogLevel logLevel) {
        return this.actualLevel.compareTo(logLevel) <= 0;
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
