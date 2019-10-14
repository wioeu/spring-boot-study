package com.example.controller;

import com.example.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/api")
public class RestApiController {

    @RequestMapping(value = "/getUser" ,method = RequestMethod.GET)
    //@GetMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setPhone("18000000000");
        user.setName("tom");
        user.setEmail("xxxxxxx@189.cn");
        return user;
    }

    //@RequestMapping(value = "/userList",method = RequestMethod.POST)
    @PostMapping("/userList")
    public List<User> userList(){
        List<User> userList = new ArrayList<>();
        User user1 = new User("张三","email@qq.com","15000000000");
        User user2 = new User("小明","abcd@163.com","18900000000");
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    @PostMapping("/mapDemo")
    public Map<String,Object> mapDemo(@RequestBody Map<String,Object> map){
        System.out.println(map.toString());
        return map;
    }

    @PostMapping("/listDemo")
    public List<String> listDemo(@RequestBody List<String> list){
        System.out.println(list.toString());
        return list;
    }

    @PostMapping("/userDemo")
    public User userDemo(@RequestBody User user){
        System.out.println(user.toString());
        return user;
    }

    @PostMapping("/stringDemo")
    public String stringDemo(@RequestBody String name){
        return name;
    }
}
