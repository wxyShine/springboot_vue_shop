package com.wxy97.shop.shiro;

import com.wxy97.shop.service.UserService;
import com.wxy97.shop.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

import javax.annotation.Resource;

/**
 * @Author: wxySmile
 * @Date 19-11-13 上午9:39
 */
public class MyRealm extends AuthenticatingRealm {

    @Resource
    UserService userServiceImpl;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        User user = userServiceImpl.findByUsername(usernamePasswordToken.getUsername());
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName()) ;
    }
}
