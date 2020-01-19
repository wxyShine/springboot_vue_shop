package com.wxy97.shop.util;

import com.wxy97.shop.pojo.Rights;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-9 下午8:19
 */
public class TreeUtil {

    //判断是否根节点
    public static boolean isRootElement(Rights rights){
        if(rights.getPid().equals("0")){
            return true;
        }
        return false;
    }

    public static List<Rights> getChildNodes(Integer pid, List<Rights> rootList){
        List<Rights> childList = new ArrayList<>();
        for(Rights n:rootList){
            if(n.getPid().equals(pid)){
                childList.add(n);
            }
        }
        //递归查找子节点的子节点并赋值
        for(Rights c:childList){
            c.setChildren(getChildNodes(c.getId(), rootList));
        }
        //子节点查找结束
        if(childList.size() == 0){
            return null;
        }
        return childList;
    }


}
