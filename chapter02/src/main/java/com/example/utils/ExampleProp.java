package com.example.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ExampleProp
 * @Description 自定义属性Bean
 * @Author liuyongqiang
 * @Date 2019/10/8 17:05
 */
//第一种方式
/*@Data
@Component
public class ExampleProp {

    @Value("${com.example.name}")
    private String name;
    @Value("${com.example.mail}")
    private String mail;
    @Value("${com.example.addr}")
    private String addr;

}*/

//第二种方式
@Data
@Component
@ConfigurationProperties(prefix = "com.example")
public class ExampleProp {

    private String name;
    private String mail;
    private String addr;

}

