package com.training.admios.types;

/**
 * Created by yohendryhurtado on 4/27/15.
 */
public enum LogLevel {
    INFO(0),
    DEBUG(1),
    WARNING(2),
    ERROR(3);

    private final int value;

    LogLevel(int value) {
        this.value = value;
    }

}
