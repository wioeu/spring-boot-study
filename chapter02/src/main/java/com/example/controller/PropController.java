package com.example.controller;

import com.example.utils.ExampleProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PropController
 * @Description PropController
 * @Author liuyongqiang
 * @Date 2019/10/8 17:09
 */
@RestController
public class PropController {

    @Autowired
    ExampleProp exampleProp;

    @GetMapping("/getProp")
    public ExampleProp getProp(){
        return exampleProp;
    }

}
