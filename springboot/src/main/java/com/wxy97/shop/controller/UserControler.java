package com.wxy97.shop.controller;
import com.wxy97.shop.pojo.User;
import com.wxy97.shop.result.Result;
import com.wxy97.shop.result.ResultFactory;
import com.wxy97.shop.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Author: wxySmile
 * @Date 20-1-3 下午7:07
 */
@RestController
public class UserControler {

    @Resource
    UserService userServiceImpl;

    @ApiOperation(value = "查询用户列表数据")
    @RequestMapping(value = "users",method = RequestMethod.GET)
    public Result  getUsers(){
        //后端实现分页查询
        //userServiceImpl.getUserListByPage(pagenum,pagesize);
        return ResultFactory.buildSuccessResult(userServiceImpl.getUserList(),"查询所有用户");
    }

    /**
     * 用户id存在修改 不存在添加用户
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value ={"/u/update","/u/save"},method = RequestMethod.POST)
    public Result update(@RequestBody User user){
        User u = userServiceImpl.updateOrSave(user);
        return ResultFactory.buildSuccessResult(u,"操作成功");
    }
    @ApiOperation(value = "根据id删除")
    @RequestMapping(value ="/u/delete")
    public Result delete(@RequestBody User user){
        userServiceImpl.deleteById(user.getId());
        return ResultFactory.buildSuccessResult(null,"删除成功");
    }
}
