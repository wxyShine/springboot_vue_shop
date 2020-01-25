package com.wxy97.shop.controller;

import com.wxy97.shop.dao.RightsJpaRepostory;
import com.wxy97.shop.pojo.Rights;
import com.wxy97.shop.result.Result;
import com.wxy97.shop.result.ResultFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-9 上午11:23
 */
@RestController
public class RightsController {

    @Resource
    RightsJpaRepostory rightsJpaRepostory;

  /*  @RequestMapping("add")
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
        Rights rights22 = new Rights();
        Rights rights23 = new Rights();
        Rights rights24 = new Rights();
        Rights rights25 = new Rights();
        Rights rights26 = new Rights();
        Rights rights27 = new Rights();
        Rights rights28 = new Rights();
        Rights rights29 = new Rights();
        Rights rights30 = new Rights();
        Rights rights31 = new Rights();
        Rights rights32 = new Rights();
        Rights rights33 = new Rights();
        Rights rights34 = new Rights();
        Rights rights35 = new Rights();
        Rights rights36 = new Rights();
        Rights rights37 = new Rights();
        Rights rights38 = new Rights();
        Rights rights39 = new Rights();
        Rights rights40 = new Rights();
        Rights rights41 = new Rights();
        Rights rights42 = new Rights();
        Rights rights43 = new Rights();
        Rights rights44 = new Rights();
        Rights rights45 = new Rights();

       rights1.setAuthName("商品管理").setPid(null).setLevel("0").setPath("goods");
        rights2.setAuthName("订单管理").setPid(null).setLevel("0").setPath("orders");
        rights3.setAuthName("权限管理").setPid(null).setLevel("0").setPath("rights");
        rights4.setAuthName("用户管理").setPid(null).setLevel("0").setPath("users");
        rights5.setAuthName("数据统计").setPid(null).setLevel("0").setPath("reports");

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

        rightsJpaRepostory.save(rights1);
        rightsJpaRepostory.save(rights2);
        rightsJpaRepostory.save(rights3);
        rightsJpaRepostory.save(rights4);
        rightsJpaRepostory.save(rights5);
        rightsJpaRepostory.save(rights6);
        rightsJpaRepostory.save(rights7);
        rightsJpaRepostory.save(rights8);
        rightsJpaRepostory.save(rights9);
        rightsJpaRepostory.save(rights10);
        rightsJpaRepostory.save(rights11);
        rightsJpaRepostory.save(rights12);
        rightsJpaRepostory.save(rights13);
        rightsJpaRepostory.save(rights14);
        rightsJpaRepostory.save(rights15);
        rightsJpaRepostory.save(rights16);
        rightsJpaRepostory.save(rights17);
        rightsJpaRepostory.save(rights18);
        rightsJpaRepostory.save(rights19);
        rightsJpaRepostory.save(rights20);
        rightsJpaRepostory.save(rights21);
        rights22.setAuthName("订单管理").setPid(2).setLevel("1").setPath("orders");
        rights27.setAuthName("添加订单").setPid(22).setLevel("2").setPath("orders");
        rights28.setAuthName("订单更新").setPid(22).setLevel("2").setPath("orders");
        rights29.setAuthName("获取订单详情").setPid(22).setLevel("2").setPath("orders");


        rights23.setAuthName("角色列表").setPid(3).setLevel("1").setPath("roles");
        rights30.setAuthName("添加角色").setPid(23).setLevel("2").setPath("roles");
        rights31.setAuthName("删除角色").setPid(23).setLevel("2").setPath("roles");
        rights32.setAuthName("角色授权").setPid(23).setLevel("2").setPath("roles");
        rights33.setAuthName("取消角色授权").setPid(23).setLevel("2").setPath("roles");
        rights34.setAuthName("获取角色列表").setPid(23).setLevel("2").setPath("roles");
        rights35.setAuthName("获取角色详情").setPid(23).setLevel("2").setPath("roles");
        rights36.setAuthName("更新角色信息").setPid(23).setLevel("2").setPath("roles");
        rights37.setAuthName("更新角色权限").setPid(23).setLevel("2").setPath("roles");

        rights24.setAuthName("权限列表").setPid(3).setLevel("1").setPath("rights");
        rights38.setAuthName("查看权限").setPid(24).setLevel("2").setPath("roles");

        rights25.setAuthName("用户列表").setPid(4).setLevel("1").setPath("users");
        rights39.setAuthName("添加用户").setPid(25).setLevel("2").setPath("users");
        rights40.setAuthName("删除用户").setPid(25).setLevel("2").setPath("users");
        rights41.setAuthName("更新用户").setPid(25).setLevel("2").setPath("users");
        rights42.setAuthName("获取用户详情").setPid(25).setLevel("2").setPath("users");
        rights43.setAuthName("分配用户角色").setPid(25).setLevel("2").setPath("users");
        rights44.setAuthName("设置管理状态").setPid(25).setLevel("2").setPath("users");

        rights26.setAuthName("数据报表").setPid(5).setLevel("1").setPath("reports");
        rights45.setAuthName("查看数据").setPid(26).setLevel("2").setPath("reports");


        rightsJpaRepostory.save(rights22);
        rightsJpaRepostory.save(rights23);
        rightsJpaRepostory.save(rights24);
        rightsJpaRepostory.save(rights25);
        rightsJpaRepostory.save(rights26);
        rightsJpaRepostory.save(rights27);
        rightsJpaRepostory.save(rights28);
        rightsJpaRepostory.save(rights29);
        rightsJpaRepostory.save(rights30);
        rightsJpaRepostory.save(rights31);
        rightsJpaRepostory.save(rights32);
        rightsJpaRepostory.save(rights33);
        rightsJpaRepostory.save(rights34);
        rightsJpaRepostory.save(rights35);
        rightsJpaRepostory.save(rights36);
        rightsJpaRepostory.save(rights37);
        rightsJpaRepostory.save(rights38);
        rightsJpaRepostory.save(rights39);
        rightsJpaRepostory.save(rights40);
        rightsJpaRepostory.save(rights41);
        rightsJpaRepostory.save(rights42);
        rightsJpaRepostory.save(rights43);
        rightsJpaRepostory.save(rights44);
        rightsJpaRepostory.save(rights45);
        return "123";
    }*/


    @RequestMapping("/rights/list")
    public Result list(){
        List<Rights> list = rightsJpaRepostory.findAll();
        return ResultFactory.buildSuccessResult(list,"获取成功");
    }

}
