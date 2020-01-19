package com.wxy97.shop.pojo;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: wxySmile
 * @Date 20-1-2 下午12:19
 */

@Entity
@Table(name = "s_user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password; //3579c5bed0f11113ebfbbcfb9371eeb5
    private boolean mg_state;
    private String name;
    private String email;
    private String tel;

    @ManyToOne()
    @JoinColumn(name="rid")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Role role;
}
