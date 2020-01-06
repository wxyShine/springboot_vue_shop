package com.wxy97.shop.controller;

import com.wxy97.shop.result.Result;
import com.wxy97.shop.result.ResultFactory;
import com.wxy97.shop.service.MenuService;
import com.wxy97.shop.util.RedisUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wxySmile
 * @Date 20-1-3 下午12:40
 */
@RestController
@CrossOrigin("*")
public class MenuController {
    @Resource
    MenuService menuServiceImpl;

    @Resource
    RedisUtil redisUtil;

    /**
     * 获取侧栏菜单列表
     *
     * @return
     */
    @RequestMapping(value = "menus",method = RequestMethod.GET)
    public Result menuList(){
        Object list = redisUtil.hget("shop", "menuList");
        if (list == null){
            System.out.println("redis缓存没有，从数据库取出并存入redis");
            list = menuServiceImpl.bulidMenuList();
            redisUtil.hset("shop","menuList",list);
        }
        return ResultFactory.buildSuccessResult(list,"请求菜单数据成功");
    }
}


