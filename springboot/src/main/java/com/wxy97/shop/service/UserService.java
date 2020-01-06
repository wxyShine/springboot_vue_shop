package com.wxy97.shop.service;

import com.wxy97.shop.pojo.User;

import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-3 上午11:09
 */
public interface UserService {

    User findByUsername(String username);

/*    *//**
     * 后端实现分页查询
     * @param
     * @param
     * @return
     *//*
    Page<User> getUserListByPage(Integer pagenum, Integer pagesize);*/

    List<User> getUserList();

    User updateOrSave(User user);

    void  deleteById(Integer id);
}
