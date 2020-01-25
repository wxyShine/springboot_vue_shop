package com.wxy97.shop.service;

import com.wxy97.shop.dao.RightsRepostory;
import com.wxy97.shop.dao.RoleRightsRepository;
import com.wxy97.shop.pojo.Rights;
import com.wxy97.shop.pojo.RoleRights;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RightsServiceImpl implements RightsService {

    @Resource
    RoleRightsRepository roleRightsRepository;
    @Resource
    RightsRepostory rightsRepostory;

    @Override
    public List<Rights> listRightsByRoleId(int rid) {
        List<RoleRights> roleRights = roleRightsRepository.findAllByRoleId(rid);
        ArrayList<Rights> list = new ArrayList<>();

        for (RoleRights roleRight : roleRights) {
            list.add(rightsRepostory.findById(roleRight.getRightId()));
        }
        return list;
    }
}
