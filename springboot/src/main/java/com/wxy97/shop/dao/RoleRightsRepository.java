package com.wxy97.shop.dao;

import com.wxy97.shop.pojo.Menu;
import com.wxy97.shop.pojo.RoleRights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-2 下午1:09
 */
public interface RoleRightsRepository extends JpaRepository<RoleRights,Integer> {
    List<RoleRights> findAllByRoleId(Integer role_id);
   // void deleteAllByRole_id(Integer role_id);
}
