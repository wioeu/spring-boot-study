package com.example.model;

import lombok.Data;

@Data
public class UserEntity {
    private String id;
    private String userName;
    private String passWord;
    private String address;
    private String email;
    private Integer level;
}
