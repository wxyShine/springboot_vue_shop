package com.wxy97.shop.service;

import com.wxy97.shop.dao.RoleRepository;
import com.wxy97.shop.pojo.Rights;
import com.wxy97.shop.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: wxySmile
 * @Date 20-1-9 下午3:36
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Resource
    RoleRepository roleRepository;

    @Override
    public List<Role> getRoleList() {
        List<Role> roles = roleRepository.findAll();
        for (Role role : roles) {
            //根节点
            List<Rights> rootRights = new ArrayList<Rights>();

            List<Rights> rights = role.getRights();
            for (Rights right : rights) {
                if (right.getLevel().equals("0")){
                    rootRights.add(right);
                }
            }
            //设置根节点
            role.setRights(rootRights);

            for (Rights rootRight : rootRights) {
                List<Rights> child = getChild(rootRight.getId(), rights);
                rootRight.setChildren(child);
            }
        }
        return roles;
    }
    /**
     * 获取子节点
     * @param id 父节点id
     * @param allRights  所有列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<Rights> getChild(Integer id,List<Rights> allRights){
        //子菜单
        List<Rights> childList = new ArrayList<Rights>();
        for (Rights nav : allRights) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if(nav.getPid().equals(id)){
                childList.add(nav);
            }
        }
        //递归
        for (Rights nav : childList) {
            nav.setChildren(getChild(nav.getId(), allRights));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if(childList.size() == 0){
            return new ArrayList<Rights>();
        }
        return childList;
    }
}
