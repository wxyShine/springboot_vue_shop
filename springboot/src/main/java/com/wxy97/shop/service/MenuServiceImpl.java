package com.wxy97.shop.service;

import com.wxy97.shop.dao.MenuRepository;
import com.wxy97.shop.pojo.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-3 下午2:14
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuRepository menuRepository;

    @Override
    public List<Menu> bulidMenuList() {
        List<Menu> menus = menuRepository.findAllByParentId(0);
        List<Menu> all = menuRepository.findAll();

        for (Menu menu : menus) {
            List<Menu> child = getChild(menu.getId(), all);
            menu.setChildren(child);
        }
        return menus;
    }

    /**
     * 获取子节点
     * @param id 父节点id
     * @param allMenu allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<Menu> getChild(int id,List<Menu> allMenu){
        //子菜单
        List<Menu> childList = new ArrayList<Menu>();
        for (Menu nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if(nav.getParentId()==id){
                childList.add(nav);
            }
        }
        //递归
        for (Menu nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        Collections.sort(childList,order());//排序
        //如果节点下没有子节点，返回一个空List（递归退出）
        if(childList.size() == 0){
            return new ArrayList<Menu>();
        }
        return childList;
    }


    /**
     * 根据菜单queue属性排序
     * @return
     */
    public Comparator<Menu> order(){
        Comparator<Menu> comparator = new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                if(o1.getQueue() != o2.getQueue()){
                    return o1.getQueue() - o2.getQueue();
                }
                return 0;
            }
        };
        return comparator;
    }
}
