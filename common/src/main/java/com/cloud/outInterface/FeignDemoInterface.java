package com.cloud.outInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product")
public interface FeignDemoInterface {

    @GetMapping(value = "/demoProduct/helloCloud")
    String getFeignDemo(@RequestParam("param")String param);
}
