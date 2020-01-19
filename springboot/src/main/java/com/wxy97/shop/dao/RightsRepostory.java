package com.wxy97.shop.dao;

import com.wxy97.shop.pojo.Rights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @Author: wxySmile
 * @Date 20-1-6 下午12:21
 */
public interface RightsRepostory extends JpaRepository<Rights,Integer> {

    List<Rights> findByLevelEquals(String level);
}
