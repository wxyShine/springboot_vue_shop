package com.wxy97.shop.service;

import com.wxy97.shop.dao.UserRepository;
import com.wxy97.shop.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wxySmile
 * @Date 20-1-3 上午11:10
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Page<User> getUserListByPage(Integer pagenum, Integer pagesize) {
        Pageable pageable = PageRequest.of(pagenum-1,pagesize);
        return userRepository.findAll(pageable);
    }

    @Override
    public User updateOrSave(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


}
