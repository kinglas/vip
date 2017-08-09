package com.yijun.common;

/**
 * Created by kinglas on 2017/7/28.
 */
public class ThisSystemException extends RuntimeException {
    public ThisSystemException(String message) {
        super(message);
    }

    public ThisSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
