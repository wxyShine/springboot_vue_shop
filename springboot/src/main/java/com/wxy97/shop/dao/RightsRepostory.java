package com.wxy97.shop.dao;

import com.wxy97.shop.pojo.Rights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


/**
 * @Author: wxySmile
 * @Date 20-1-6 下午12:21
 * 自定义 清除jpa一级缓存
 */
@Repository
public class RightsRepostory {

    @PersistenceContext
    private EntityManager em;

    public Rights findById(Integer id) {
        String sql="select * from s_rights where id="+id;
        Query query = em.createNativeQuery(sql, Rights.class);
        em.clear(); // 清除缓存
        return (Rights) query.getResultList().get(0);
    }
}
