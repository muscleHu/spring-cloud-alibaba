package com.cloud.service.impl;

import com.cloud.outInterface.DubboInterface;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DubboServiceImpl implements DubboInterface {
    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }
}
