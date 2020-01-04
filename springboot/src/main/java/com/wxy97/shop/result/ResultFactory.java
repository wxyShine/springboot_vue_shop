package com.wxy97.shop.result;

/**
 * @Author: wxySmile
 * @Date 20-1-2 上午11:58
 */
public class ResultFactory {

    public static Result buildSuccessResult(Object data,String message) {
        return buildResult(data,message,StatusCode.SUCCESS.code);
    }

    public static Result buildFailResult(String message) {
        return buildResult(null,message,StatusCode.FAIL.code);
    }

    public static Result buildResult(Object data, String message,Integer resultCode) {
        return new Result(data, message, resultCode);
    }

}
