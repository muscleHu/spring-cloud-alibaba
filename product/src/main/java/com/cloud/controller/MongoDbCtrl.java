package com.cloud.controller;

import com.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongoDbCtrl {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/insert")
    public void insert() {
        User user = new User();
        user.setId(1);
        user.setName("hjt");
        user.setCode("001");
        user.setShadingKey("1");
        mongoTemplate.insert(user);
    }

    @GetMapping("/get")
    public List<User> getUser() {
        return mongoTemplate.findAll(User.class);
    }
}
