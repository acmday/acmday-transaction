package com.acmday.transaction.server.demo;

import com.acmday.transaction.server.BaseClass;
import com.acmday.transaction.server.bo.User;
import com.acmday.transaction.server.interfaces.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author acmday.
 * @date 2020/6/6.
 */
@Slf4j
public class MybatisDemo extends BaseClass {
//
//    @Test
//    public void mapperTest() {
//        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(
//                MybatisDemo.class.getClassLoader(),
//                new Class<?>[]{UserMapper.class},
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println(method.getName());
//                        return null;
//                    }
//                });
//        List<User> users = userMapper.selectUserList(1, "acmday");
//        log.info("act=mapperTest users={}" + users.toString());
//    }
}