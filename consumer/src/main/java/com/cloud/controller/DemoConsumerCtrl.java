package com.cloud.controller;

import com.cloud.FeignDemoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demoConsumer")
public class DemoConsumerCtrl {
    @Autowired
    private FeignDemoInterface feignDemoInterface;

    @RequestMapping("/helloCloud")
    public String helloCloud(String param){
        return feignDemoInterface.getFeignDemo("dsahjksadgasd");
    }
}
