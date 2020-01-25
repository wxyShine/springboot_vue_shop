package com.wxy97.shop.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;
import java.util.Set;


/**
 * @Author: wxySmile
 * @Date 20-1-3 下午6:52
 */
@Entity
@Table(name = "s_role")
@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "d_esc")
    private String desc;

    @Transient
    private List<Rights> rights;
}
