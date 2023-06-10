package com.cloud.service.impl;

import com.cloud.service.AbstractService;
import com.cloud.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService,AbstractService {
    public static void main(String[] args) {
        AbstractService userService=AbstractService.getInstance();
    }
}
