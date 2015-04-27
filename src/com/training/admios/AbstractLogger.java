package com.training.admios;

import java.util.Calendar;
import java.util.Formatter;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public abstract class AbstractLogger {

    abstract void log(String message, LogLevel level);

    String getFormatedMessage(String message, LogLevel level) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("%s : %s",level, message);
        return formatter.toString();
    }
}
