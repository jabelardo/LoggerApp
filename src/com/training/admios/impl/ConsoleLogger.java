package com.training.admios.impl;

import com.training.admios.AbstractLogger;
import com.training.admios.types.LogLevel;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(LogLevel level) {
        this.setCurrentLevel(level);
    }

    @Override
    public void logImp(String message, LogLevel level) {
        System.out.println(getFormatedMessage(message, level));
    }
}
