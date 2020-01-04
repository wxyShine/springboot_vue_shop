package com.wxy97.shop.pojo;
import lombok.Data;

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
    private String password;
    private boolean mg_state;
    private String name;
    private String email;
    private String tel;
    @ManyToOne()
    @JoinColumn(name="rid")
    private Role role;
}
