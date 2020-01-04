package com.wxy97.shop.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: wxySmile
 * @Date 20-1-3 下午12:07
 */
@Entity
@Table(name = "s_menu")
@Data
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String path;
    @Column(columnDefinition="INT default 0")
    private int queue;
    @Column(columnDefinition="INT default 0")
    private int parentId;

    @Transient
    private List<Menu> children;

}
