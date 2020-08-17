package com.acmday.transaction.server.mybatis;

import com.acmday.transaction.dao.mapper.StudentMapper;
import com.acmday.transaction.server.BaseClass;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author acmday.
 * @date 2020/6/8.
 */
@Slf4j
public class SqlSessionTest extends BaseClass {

    @Resource
    private DataSource dataSource;

    @Test
    public void sqlSessionTest() {

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(StudentMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            String student = session.selectOne("com.acmday.transaction.dao.mapper.StudentMapper.getAddressById",1);
            log.info("act=sqlSessionTest student={}", new Gson().toJson(student));
        }
    }
}