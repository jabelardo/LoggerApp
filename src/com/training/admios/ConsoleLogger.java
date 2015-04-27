package com.training.admios;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger() {

    }

    @Override
    public void log(String message, LogLevel level) {
        System.out.println(getFormatedMessage(message, level));
    }
}
