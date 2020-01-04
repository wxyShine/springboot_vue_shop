package com.wxy97.shop.dao;

import com.wxy97.shop.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author: wxySmile
 * @Date 20-1-2 下午1:09
 */
public interface UserRepository  extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    @Override
    Page<User> findAll(Pageable pageable);

    @Override
    void deleteById(Integer integer);
}
