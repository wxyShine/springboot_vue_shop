package com.wxy97.shop.service;

import com.wxy97.shop.pojo.User;
import org.springframework.data.domain.Page;

/**
 * @Author: wxySmile
 * @Date 20-1-3 上午11:09
 */
public interface UserService {

    User findByUsername(String username);

    Page<User> getUserListByPage(Integer pagenum, Integer pagesize);

    User updateOrSave(User user);

    void  deleteById(Integer id);
}
