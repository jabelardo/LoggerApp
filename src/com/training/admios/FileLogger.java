package com.training.admios;

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
    public void performLog(String message, LogLevel level) {
        this.writeLog(this.getFormatedMessage(message, level));
    }

    protected void writeLog(String message){

        File file = new File(this.path);
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
