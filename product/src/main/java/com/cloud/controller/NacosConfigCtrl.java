package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
@RefreshScope
public class NacosConfigCtrl {

   /* @Value("${test.name}")
    private String testName;

    @Value("${age}")
    private String age;

    @Value("${search.url}")
    private String url;

    @GetMapping("/getName")
    public String getConfigInfo() {
        return testName;
    }

    @GetMapping("/age")
    public String getAge() {
        return age;
    }

    @GetMapping("/url")
    public String getUrl() {
        return age;
    }*/
}
