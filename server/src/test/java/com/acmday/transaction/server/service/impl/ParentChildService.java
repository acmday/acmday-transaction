package com.acmday.transaction.server.service.impl;

import com.acmday.transaction.dao.model.Student;
import com.acmday.transaction.dao.service.StudentDaoJdbcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author acmday.
 * @date 2020/8/18.
 */
@Service
@Slf4j
public class ParentChildService {

    @Resource
    private StudentDaoJdbcService jdbcService;

    @Transactional
    public void parent() {
       /* try {
            child();
        }catch (Exception e) {
            log.error("act=parent e=", e);
        }*/

        //测试parent()接口除0异常，child没有1/0时，child是否会回滚（答案是：会）
        //直接调用，没有被代理调用。如果一定要这样做，可以获取到当前AopProxy,然后通过aop代理来调用child方法：
        //((ParentChildService)AopContext.currentProxy()).child();
        //child();

        Student student = new Student(3, "acmday3", "Beijing3", (byte) 20);
        jdbcService.addStudent(student);

        //child()抛了异常，测试parent()的插入是否会回滚（答案是：会）
        //child();

        //int a = 1/0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void child() {
        Student student = new Student(2, "acmday2", "Beijing2", (byte) 20);
        jdbcService.addStudent(student);
        int a = 1/0;
    }
}
