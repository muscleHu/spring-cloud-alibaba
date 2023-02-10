package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demoProduct")
public class DemoProductCtrl {

    @RequestMapping("/helloCloud")
    public String helloCloud(String param){

        return "hello cloud "+param;
    }
}
