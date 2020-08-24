package com.acmday.transaction.server.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author acmday.
 * @date 2020/8/17.
 */
@Component
@Slf4j
public class TransactionUtil {

    @Resource
    private DataSourceTransactionManager transactionManager;

    public TransactionStatus begin() {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        return transactionManager.getTransaction(definition);
    }

    public void commit(TransactionStatus transactionStatus) {
        transactionManager.commit(transactionStatus);
    }

    public void rollback(TransactionStatus transactionStatus) {
        transactionManager.rollback(transactionStatus);
    }
}
