package com.training.admios;

import java.io.*;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class FileLogger extends AbstractLogger {

    private final String path;

    public FileLogger(String path) {
        this.path = path;
    }

    @Override
    public void log(String message, LogLevel level) {
        this.writeLog(this.getFormatedMessage(message, level));
    }

    void writeLog(String message){

        File file = new File(this.path);

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            writer.write(message);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}