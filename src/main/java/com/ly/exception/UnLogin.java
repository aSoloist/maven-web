package com.ly.exception;

/**
 * Created by ly on 2017/10/18 21:46
 */
public class UnLogin extends RuntimeException {
    public UnLogin() {
        super("未登录");
    }

    public UnLogin(String message) {
        super(message);
    }
}
