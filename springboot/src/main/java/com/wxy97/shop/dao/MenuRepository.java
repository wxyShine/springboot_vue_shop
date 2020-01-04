package com.wxy97.shop.dao;

import com.wxy97.shop.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-2 下午1:09
 */
public interface MenuRepository extends JpaRepository<Menu,Integer> {
    @Override
    List<Menu> findAll();

    List<Menu> findAllByParentId(int parentId);


}
