package com.wxy97.shop.controller;


import com.wxy97.shop.pojo.User;
import com.wxy97.shop.result.Result;
import com.wxy97.shop.result.ResultFactory;
import com.wxy97.shop.util.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author: wxySmile
 * @Date 20-1-2 下午12:12
 */
@RestController
public class LoginController {
    @ApiOperation("登录")
    @ApiImplicitParams({@ApiImplicitParam(name="username",value = "用户名",required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)})
    @ApiImplicitParam(name="password",value = "密码",required = true)
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        SimpleHash simpleHash = new SimpleHash("MD5",user.getPassword(),user.getUsername(),1024);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), simpleHash.toString());
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(token);
            //获得用户对象
            User resultUser = (User) subject.getPrincipal();
            HashMap<Object, Object> data = new HashMap<>();
            data.put("id",resultUser.getId());
            data.put("name",resultUser.getName());
            //生成token返回给客户端
            data.put("token",JWTUtil.sign(resultUser));
            return ResultFactory.buildSuccessResult(data,"登录成功");
        } catch (AuthenticationException e) {
            //登录失败
            return ResultFactory.buildFailResult("登录失败");
        }
    }
/*    public static void main(String[] args) {
        //明码
        String password = "wxy";
        //加密算法
        String algorithmName = "MD5";
        //要加密的密码
        Object source = password;
        //盐值，一般都是用户名或者userid，要保证唯一
        Object salt = "wxy";
        //加密次数
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        //打印出经过盐值、加密次数、md5后的密码
        System.out.println(simpleHash.toString());
    }*/

}
