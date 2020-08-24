package com.acmday.transaction.server.dao;

import com.acmday.transaction.dao.service.StudentDaoService;
import com.acmday.transaction.server.BaseClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author acmday.
 * @date 2020/8/24.
 */
@Slf4j
public class StudentDaoTest extends BaseClass {

    @Resource
    private StudentDaoService studentDaoService;

    @Test
    public void getData() {
        String resutlt = studentDaoService.getAddressById(1);
        log.info("act=getData result={}", resutlt);
    }
}
