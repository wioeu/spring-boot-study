package com.example.controller;

import com.example.model.RedisModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("setStringValue")
    public RedisModel setStringValue(@RequestBody RedisModel redisModel){
        String key = redisModel.getStrKey();
        String val = redisModel.getStrVal();
        stringRedisTemplate.opsForValue().set(key,val);
        return redisModel;
    }

    @GetMapping("getStringValue")
    public RedisModel getStringValue(@RequestBody RedisModel redisModel){
        String key = redisModel.getStrKey();
        String val = stringRedisTemplate.opsForValue().get(key);
        redisModel.setStrVal(val);
        return redisModel;
    }

    @GetMapping("setRedisValue")
    public RedisModel setRedisValue(@RequestBody RedisModel redisModel){
        String key = redisModel.getStrKey();
        String val = redisModel.getStrVal();
        redisTemplate.opsForValue().set(key,val);
        return redisModel;
    }

    @GetMapping("getRedisValue")
    public RedisModel getRedisValue(@RequestBody RedisModel redisModel){
        String key = redisModel.getStrKey();
        String val = String.valueOf(redisTemplate.opsForValue().get(key));
        redisModel.setStrVal(val);
        return redisModel;
    }

}
