package com.wxy97.shop.controller;

import com.wxy97.shop.dao.RoleRepository;
import com.wxy97.shop.pojo.Rights;
import com.wxy97.shop.pojo.Role;
import com.wxy97.shop.result.Result;
import com.wxy97.shop.result.ResultFactory;
import com.wxy97.shop.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-9 下午12:49
 */
@RestController
public class RoleController {

    @Resource
    RoleService roleServiceImpl;

    @RequestMapping("/role/list")
    public Result roleList(){
        List<Role> list = roleServiceImpl.getRoleList();
        return ResultFactory.buildSuccessResult(list,"获取成功!");
    }



}
