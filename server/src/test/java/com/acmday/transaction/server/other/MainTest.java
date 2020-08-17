package com.acmday.transaction.server.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author wushaofeng.
 * @date 2020/8/17.
 * 不依赖数据库的测试.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MainTest {
    public static void main(String[] args) {
        SpringApplication.run(MainTest.class, args);
    }
}
