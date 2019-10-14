package com.example.controller;

import com.example.dto.CommonDTO;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("saveUser")
    public User saveUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @PostMapping("deleteUserById")
    public String deleteUserById(@RequestBody User user){
        return userRepository.deleteUserById(user.getId());
    }

    @PostMapping("findUserById")
    public User findUserById(@RequestBody User user){
        return userRepository.findUserById(user.getId());
    }

    @PostMapping("findByUserNameOrAddress")
    public User findByUserNameOrAddress(@RequestBody User user){
        return userRepository.findByUserNameOrAddress(user.getUserName(),user.getAddress());
    }

    @PostMapping("findByLevelBetween")
    public List<User> findByPassWordBetween(@RequestBody CommonDTO commonDTO){
        return userRepository.findByLevelBetween(commonDTO.getStart(),commonDTO.getEnd());
    }

    @PostConstruct
    public List<User> importUser(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            User user = new User();
            user.setAddress("address"+i);
            user.setEmail("email"+i+"@mail.com");
            user.setPassWord("passWord"+i);
            user.setUserName("userName"+i);
            user.setLevel(i);
            userList.add(user);
        }
        return userRepository.saveAll(userList);
    }

}
