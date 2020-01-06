package com.wxy97.shop.config;
import com.wxy97.shop.result.Result;
import com.wxy97.shop.result.ResultFactory;
import com.wxy97.shop.util.JWTUtil;
import com.wxy97.shop.util.JsonUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: wxySmile
 * @Date 20-1-3 下午5:11
 * 完成token认证
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        System.out.println("请求地址"+request.getRequestURI());
        response.setCharacterEncoding("utf-8");
        //获取请求头的token Authorization属性
        String token = request.getHeader("Authorization");
        if(token != null){
            boolean result = JWTUtil.verify(token);
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try{
            Result result = ResultFactory.buildFailResult("token认证失败");
            response.getWriter().append(JsonUtils.toJson(result));
            System.out.println("认证失败,未通过拦截器");
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;

    }
}
