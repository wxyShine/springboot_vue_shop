package com.wxy97.shop.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wxySmile
 * @Date 20-1-9 上午11:15
 */

@Entity
@Getter
@Setter
@Table(name = "s_rights")
@Accessors(chain = true)//链式结构写法
@JsonIgnoreProperties( {"handler", "fieldHandler"})
public class Rights implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String authName;
    private String level;
    private String path;
    private Integer  pid;

    @ManyToMany(mappedBy = "rights")
    @JsonIgnore
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private List<Role> roles ;

    @Transient
    private List<Rights> children;


}
