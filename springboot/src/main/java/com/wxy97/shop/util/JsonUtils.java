package com.wxy97.shop.util;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @Author: wxySmile
 * @Date 20-1-3 下午5:51
 * 在拦截器中返回Json
 */
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 对象转json
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj){
         if (obj == null){
         }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
