package com.training.admios.impl;

import com.training.admios.AbstractLogger;
import com.training.admios.exception.LoggerException;
import com.training.admios.types.LogLevel;

import java.io.*;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class FileLogger extends AbstractLogger {

    private final String path;

    public FileLogger(LogLevel level, String path) {
        this.path = path;
        this.setCurrentLevel(level);
    }

    @Override
    public void logImp(String message, LogLevel level) {
        this.writeLog(this.getFormatedMessage(message, level));
    }

    protected void writeLog(String message) {
        File file = new File(this.path);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)))) {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new LoggerException(e);
        }
    }
}
