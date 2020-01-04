package com.wxy97.shop.result;


import lombok.Data;

import java.util.HashMap;

/**
 * @Author: wxySmile
 * @Date 20-1-2 上午11:50
 */
@Data
public class Result {

    private Object data;
    private HashMap<String,Object> meta =new HashMap<>();

    public Result(Object data, String msg, Integer status) {
        meta.put("msg",msg);
        meta.put("status",status);
        this.data = data;
    }

}
