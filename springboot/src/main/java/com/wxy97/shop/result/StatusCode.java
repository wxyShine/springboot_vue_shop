package com.wxy97.shop.result;

/**
 * @Author: wxySmile
 * @Date 20-1-2 上午11:55
 */
public enum  StatusCode {
    SUCCESS(200),
    FAIL(400);
    public int code;

    StatusCode(int code) {
        this.code = code;
    }
}
