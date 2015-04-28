package com.training.admios;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class AsyncLogger extends AbstractLogger {

    private final AbstractLogger logger;

    public AsyncLogger(AbstractLogger logger) {
        this.logger = logger;
    }

    @Override
    public synchronized void logImp(String message, LogLevel logLevel) {
        Runnable task = () -> logger.log(message, logLevel);
        new Thread(task).start();
    }

    @Override
    public LogLevel getCurrentLevel() {
        return this.logger.getCurrentLevel();
    }
}