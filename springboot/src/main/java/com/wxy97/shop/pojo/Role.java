package com.wxy97.shop.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: wxySmile
 * @Date 20-1-3 下午6:52
 */
@Entity
@Table(name = "s_role")
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "d_esc")
    private String desc;
}
