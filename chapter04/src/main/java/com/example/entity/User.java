package com.example.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    public String id;

    @Column(nullable = false,unique = true,length = 50)
    private String userName;

    @Column(nullable = false,length = 100)
    private String passWord;

    @Column(nullable = false,length = 200)
    private String address;

    @Column(length = 50)
    private String email;

    @Column(nullable = false,length = 10)
    private Integer level;


}
