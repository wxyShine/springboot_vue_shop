package com.wxy97.shop.controller;

import com.wxy97.shop.dao.RightsRepostory;
import com.wxy97.shop.pojo.Menu;
import com.wxy97.shop.pojo.Rights;
import com.wxy97.shop.result.Result;
import com.wxy97.shop.result.ResultFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-9 上午11:23
 */
@RestController
public class RightsController {

    @Resource
    RightsRepostory rightsRepostory;

    @RequestMapping("add")
    public String add(){
        Rights rights1 = new Rights();
        Rights rights2 = new Rights();
        Rights rights3 = new Rights();
        Rights rights4 = new Rights();
        Rights rights5 = new Rights();
        Rights rights6 = new Rights();
        Rights rights7 = new Rights();
        Rights rights8 = new Rights();
        Rights rights9 = new Rights();
        Rights rights10 = new Rights();
        Rights rights11 = new Rights();
        Rights rights12 = new Rights();
        Rights rights13 = new Rights();
        Rights rights14 = new Rights();
        Rights rights15 = new Rights();
        Rights rights16 = new Rights();
        Rights rights17 = new Rights();
        Rights rights18 = new Rights();
        Rights rights19 = new Rights();
        Rights rights20 = new Rights();
        Rights rights21 = new Rights();


        rights1.setAuthName("商品管理").setPid(0).setLevel("0").setPath("goods");
        rights2.setAuthName("订单管理").setPid(0).setLevel("0").setPath("orders");
        rights3.setAuthName("权限管理").setPid(0).setLevel("0").setPath("rights");
        rights4.setAuthName("用户管理").setPid(0).setLevel("0").setPath("users");
        rights5.setAuthName("数据统计").setPid(0).setLevel("0").setPath("reports");

        rights6.setAuthName("商品列表").setPid(1).setLevel("1").setPath("goods");
        rights7.setAuthName("分类参数").setPid(1).setLevel("1").setPath("params");
        rights8.setAuthName("商品分类").setPid(1).setLevel("1").setPath("categories");

        rights9.setAuthName("添加商品").setPid(6).setLevel("2").setPath("goods");
        rights10.setAuthName("商品修改").setPid(6).setLevel("2").setPath("goods");
        rights11.setAuthName("商品删除").setPid(6).setLevel("2").setPath("goods");
        rights12.setAuthName("更新商品图片").setPid(6).setLevel("2").setPath("goods");
        rights13.setAuthName("更新商品属性").setPid(6).setLevel("2").setPath("goods");
        rights14.setAuthName("更新商品状态").setPid(6).setLevel("2").setPath("goods");
        rights15.setAuthName("获取商品详情").setPid(6).setLevel("2").setPath("goods");

        rights16.setAuthName("获取参数列表").setPid(7).setLevel("2").setPath("params");
        rights17.setAuthName("创建商品参数").setPid(7).setLevel("2").setPath("params");
        rights18.setAuthName("删除商品参数").setPid(7).setLevel("2").setPath("params");

        rights19.setAuthName("添加分类").setPid(8).setLevel("2").setPath("categories");
        rights20.setAuthName("删除分类").setPid(8).setLevel("2").setPath("categories");
        rights21.setAuthName("获取分类详情").setPid(8).setLevel("2").setPath("categories");

        rightsRepostory.save(rights1);
        rightsRepostory.save(rights2);
        rightsRepostory.save(rights3);
        rightsRepostory.save(rights4);
        rightsRepostory.save(rights5);
        rightsRepostory.save(rights6);
        rightsRepostory.save(rights7);
        rightsRepostory.save(rights8);
        rightsRepostory.save(rights9);
        rightsRepostory.save(rights10);
        rightsRepostory.save(rights11);
        rightsRepostory.save(rights12);
        rightsRepostory.save(rights13);
        rightsRepostory.save(rights14);
        rightsRepostory.save(rights15);
        rightsRepostory.save(rights16);
        rightsRepostory.save(rights17);
        rightsRepostory.save(rights18);
        rightsRepostory.save(rights19);
        rightsRepostory.save(rights20);
        rightsRepostory.save(rights21);
        return "123";
    }


    @RequestMapping("/rights/list")
    public Result list(){
        List<Rights> list = rightsRepostory.findAll();
        return ResultFactory.buildSuccessResult(list,"获取成功");
    }

}
