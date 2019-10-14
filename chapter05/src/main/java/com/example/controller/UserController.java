package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("getAll")
    public List<UserEntity> getAll(){
        return userMapper.getAll();
    }

    @PostMapping("getOne")
    public UserEntity getOne(@RequestBody UserEntity userEntity){
        return userMapper.getOne(userEntity.getId());
    }

    @PostMapping("insertUser")
    public UserEntity insertUser(@RequestBody UserEntity userEntity){
        userMapper.insertUser(userEntity);
        return userEntity;
    }

    @PostMapping("updateUser")
    public UserEntity updateUser(@RequestBody UserEntity userEntity){
        userMapper.updateUser(userEntity);
        return userEntity;
    }

    @PostMapping("deleteUser")
    public UserEntity deleteUser(@RequestBody UserEntity userEntity){
        userMapper.deleteUser(userEntity);
        return userEntity;
    }
}
