package com.acmday.transaction.server.mybatis;

import com.acmday.transaction.server.BaseNoDbClass;
import com.acmday.transaction.server.bo.User;
import com.acmday.transaction.server.service.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @author acmday.
 * @date 2020/6/6.
 */
@Slf4j
public class MybatisTest extends BaseNoDbClass {

    /**
     * mybatis底层原理.
     */
    @Test
    public void mapperTest() {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(
                UserMapper.class.getClassLoader(),
                new Class<?>[]{UserMapper.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        log.info("act=mapperTest method={}, sql={}", method.getName(), method.getAnnotation(Select.class).value());
                        return method.invoke(new UserMapper() {
                            @Override
                            public List<User> selectUserList(int id, String name) {
                                return Collections.singletonList(new User(10010, "acmday", "Beijing"));
                            }
                        }, args);
                    }
                });
        List<User> users = userMapper.selectUserList(1, "acmday");
        log.info("act=mapperTest users={}", users.toString());
    }
}