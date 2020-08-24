package com.acmday.transaction.server.other.JdkTest;

import com.acmday.transaction.server.other.MainTest;
import com.acmday.transaction.server.service.PeopleService;
import com.acmday.transaction.server.service.impl.PeopleHandler;
import com.acmday.transaction.server.service.impl.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author acmday.
 * @date 2020/8/17.
 */
@Slf4j
@SpringBootTest(classes = MainTest.class)
@RunWith(value = SpringRunner.class)
public class ProxyTest {

    @Test
    public void proxyTest() {
        PeopleService people = new TeacherService();
        //代理对象的调用处理程序，我们将要代理的真实对象传入代理对象的调用处理的构造函数中，最终代理对象的调用处理程序会调用真实对象的方法
        InvocationHandler peopleHandler = new PeopleHandler(people);
        PeopleService proxy = (PeopleService) Proxy.newProxyInstance(peopleHandler.getClass().getClassLoader(), people.getClass().getInterfaces(), peopleHandler);
        log.info("act=proxyTest res={}", proxy.work());
    }
}
