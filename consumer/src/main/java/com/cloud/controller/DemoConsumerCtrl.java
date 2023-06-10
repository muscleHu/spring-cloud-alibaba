package com.cloud.controller;

import com.cloud.outInterface.DubboInterface;
import com.cloud.outInterface.FeignDemoInterface;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demoConsumer")
public class DemoConsumerCtrl {
    @Autowired
    private FeignDemoInterface feignDemoInterface;

    @DubboReference
    private DubboInterface dubboInterface;

    @RequestMapping("/helloCloud")
    public String helloCloud(String param){
        return feignDemoInterface.getFeignDemo("dsahjksadgasd");
    }

    @RequestMapping("/helloDubbo")
    public String helloDubbo(String param){
        return dubboInterface.sayHello("dubbo");
    }
}
