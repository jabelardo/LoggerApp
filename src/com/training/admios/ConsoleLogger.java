package com.training.admios;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(LogLevel level) {
        this.setCurrentLevel(level);
    }

    @Override
    public void performLog(String message, LogLevel level) {
        System.out.println(getFormatedMessage(message, level));
    }
}
