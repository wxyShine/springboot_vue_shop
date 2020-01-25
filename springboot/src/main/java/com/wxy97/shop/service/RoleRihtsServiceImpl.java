package com.wxy97.shop.service;

import com.wxy97.shop.dao.RoleRightsRepository;
import com.wxy97.shop.pojo.RoleRights;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleRihtsServiceImpl implements RoleRihtsService {

    @Resource
    RoleRightsRepository roleRightsRepository;

    @Override
    public List<RoleRights> findAllByRid(Integer rid) {
        return roleRightsRepository.findAllByRoleId(rid);
    }
}
