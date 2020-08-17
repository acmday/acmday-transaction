package com.acmday.transaction.server.service.impl;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wushaofeng.
 * @date 2020/8/17.
 */
@Slf4j
public class PeopleHandler implements InvocationHandler {

    //代理类中的真实对象
    private Object obj;

    public PeopleHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("act=invoke desc=before invoke...........");
        Object invoke = method.invoke(obj, args);
        log.info("act=invoke desc=after invoke...........");
        return invoke;
    }
}
