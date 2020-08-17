package com.acmday.transaction.server.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

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
        return transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    public void commit(TransactionStatus transactionStatus) {
        transactionManager.commit(transactionStatus);
    }

    public void rollback(TransactionStatus transactionStatus) {
        transactionManager.rollback(transactionStatus);
    }
}
