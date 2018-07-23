package com.wen.test.vo;

import lombok.Data;
import sun.applet.Main;


import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    private Integer user_id;
    @Column
    private String username;
    @Column
    private String password;

}
