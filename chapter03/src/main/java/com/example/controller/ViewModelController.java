package com.example.controller;

import com.example.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/view")
public class ViewModelController {

    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        map.put("name","james");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","jack");
        return "hello";
    }

    @RequestMapping("/user")
    public String users(User user){
        user.setName("alis");
        user.setPhone("18000000000");
        user.setEmail("xxxxxxxx@qq.com");
        return "user";
    }

    @RequestMapping("/demo1/{id}")
    public String demo1(@PathVariable(name = "id")String id){
        System.out.println("id="+id);
        return "demo1";
    }

    @RequestMapping("/demo2")
    public String demo2(@RequestParam(name="name")String name,Model model){
        model.addAttribute("name",name);
        System.out.println("name="+name);
        return "demo2";
    }

    @RequestMapping("/demo3/{id}")
    public String demo3(@PathVariable(name="id")String id,@RequestParam(name="name")String name){
        System.out.println("id="+id);
        System.out.println("name="+name);
        return "demo3";
    }

    @RequestMapping("/demo4")
    public String demo4(User user){
        System.out.println(user.toString());
        return "demo4";
    }
}
