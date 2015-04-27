package com.training.admios;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class AsyncLogger extends FileLogger implements Runnable {

    String message;

    public AsyncLogger(String path) {
        super(path);
    }

    @Override
    public synchronized void log(String message, LogLevel logLevel) {
        this.setMessage(getFormatedMessage(message, logLevel));
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        this.writeLog(this.getMessage());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}