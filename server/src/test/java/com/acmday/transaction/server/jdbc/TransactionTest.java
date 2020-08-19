package com.acmday.transaction.server.jdbc;

import com.acmday.transaction.dao.model.Student;
import com.acmday.transaction.dao.service.StudentDaoJdbcService;
import com.acmday.transaction.server.BaseClass;
import com.acmday.transaction.server.service.impl.ParentChildService;
import com.acmday.transaction.server.util.TransactionUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;

/**
 * @author acmday.
 * @date 2020/8/17.
 */
@Slf4j
public class TransactionTest extends BaseClass {

    @Resource
    private StudentDaoJdbcService jdbcService;

    @Resource
    private TransactionUtil transactionUtil;

    @Resource
    private ParentChildService parentChildService;

    @Test
    public void parendChild() {
        parentChildService.parent();
    }

    @Test
    public void addStudent() {
        TransactionStatus status = null ;
        try {
            status = transactionUtil.begin();
            jdbcService.addStudent(new Student(2020, "acmday20", "Beijing20", (byte) 20));
            int value = 1 / 0;
            if(status != null) {
                transactionUtil.commit(status);
            }
        }catch (Exception e) {
            log.error("act=addStudent e=", e);
        }finally {
            if(status != null) {
                transactionUtil.rollback(status);
            }
        }
    }
}
