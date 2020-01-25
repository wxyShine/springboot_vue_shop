package com.wxy97.shop.service;

import com.wxy97.shop.pojo.Rights;

import java.util.List;

public interface RightsService {

     List<Rights> listRightsByRoleId(int rid);
}
