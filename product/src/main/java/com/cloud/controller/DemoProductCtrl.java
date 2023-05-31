package com.cloud.controller;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.entity.User;
import com.cloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.List;

@RestController
@RequestMapping("/demoProduct")
public class DemoProductCtrl {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/helloCloud")
    public String helloCloud(String param){
        return "hello cloud "+param;
    }

    @GetMapping("/getUser")
    public List<User> getUser(@RequestParam("shadingKey")String shadingKey){
        QueryWrapper<User> userWrapper= new QueryWrapper<User>().eq("shading_key",shadingKey);
        return userMapper.selectList(userWrapper);
    }

    @RequestMapping("/insertUser")
    public void insertUser(){
        User user=new User();
        user.setId(2);
        user.setCode("xxx");
        user.setName("xxxName");
        User user1=new User();
        user1.setId(3);
        user1.setCode("xxx");
        user1.setName("xxxName");
        userMapper.insert(user);
        userMapper.insert(user1);
    }

    @RequestMapping("/updateUser")
    public void updateUser(){
        User user=new User();
        user.setId(1);
        user.setCode("xxx111111");
        user.setName("xxxName");
        userMapper.updateById(user);
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(){
        User user=new User();
        user.setId(1);
        userMapper.deleteById(user);
    }
}
