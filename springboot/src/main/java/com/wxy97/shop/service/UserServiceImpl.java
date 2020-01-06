package com.wxy97.shop.service;

import com.wxy97.shop.dao.UserRepository;
import com.wxy97.shop.pojo.User;
import com.wxy97.shop.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-3 上午11:10
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Resource
    RedisUtil redisUtil;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUserList() {
        List<User>  userList = (List<User>) redisUtil.hget("shop", "userList");
        if (userList == null){
           userList=userRepository.findAll();
           redisUtil.hset("shop","userList",userList);
        }
        return userList;
    }

/*    *//**
     * 后端实现分页查询
     * @param
     * @param
     * @return
     *//*
    @Override
    public Page<User> getUserListByPage(Integer pagenum, Integer pagesize) {
        Pageable pageable = PageRequest.of(pagenum-1,pagesize);
        return userRepository.findAll(pageable);
    }*/

    @Override
    public User updateOrSave(User user) {
        redisUtil.hdel("shop","userList");
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        redisUtil.hdel("shop","userList");
        userRepository.deleteById(id);
    }


}
