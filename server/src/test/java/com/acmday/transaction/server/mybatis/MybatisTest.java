package com.acmday.transaction.server.mybatis;

import com.acmday.transaction.server.BaseClass;
import lombok.extern.slf4j.Slf4j;

/**
 * @author acmday.
 * @date 2020/6/6.
 */
@Slf4j
public class MybatisTest extends BaseClass {
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