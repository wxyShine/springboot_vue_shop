package com.wxy97.shop.service;

import com.wxy97.shop.pojo.RoleRights;

import java.util.List;

public interface RoleRihtsService {

    List<RoleRights> findAllByRid(Integer rid);
}
