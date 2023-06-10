package com.cloud.service;

import com.cloud.service.impl.UserServiceImpl;

public interface AbstractService {
    default void fun() {
        System.out.println("fun");
    }

    static AbstractService getInstance() {
        System.out.println("getInstance");
        return new UserServiceImpl();
    }
}
