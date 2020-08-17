package com.acmday.transaction.server.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author acmday.
 * @date 2020/6/4.
 */
@Configuration
@Slf4j
@MapperScan(basePackages = AcmDayDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "fromSqlSessionFactory")
public class AcmDayDataSourceConfig {

    static final String PACKAGE = "com.acmday.transaction.dao.mapper";
    private static final String MAPPER_XML = "classpath*:com/acmday/transaction/dao/mapper/**/*.xml";

    @Value("${spring.datasource.day.username}")
    private String userName;

    @Value("${spring.datasource.day.password}")
    private String passwd;

    @Value("${spring.datasource.day.url}")
    private String url;

    @Value("${spring.datasource.day.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.day.maxPoolSize}")
    private Integer maxPoolSize;

    @Value("${spring.datasource.day.initialPoolSize}")
    private Integer initialPoolSize;

    @Value("${spring.datasource.day.minPoolSize}")
    private Integer minPoolSize;

    @Bean(name = "configDayDataSource")
    @Primary
    public DataSource acmDayDataSourceConfig() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(userName);
        dataSource.setPassword(passwd);
        dataSource.setInitialPoolSize(initialPoolSize);
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMinPoolSize(minPoolSize);

        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(false);

        //preferredTestQuery用于检测数据库连接测试，检测数据库是否能连接成功。
        dataSource.setPreferredTestQuery("select 1");
        dataSource.setIdleConnectionTestPeriod(180);

        log.info(" act=acmDayDataSourceConfig initialPoolSize={},maxPoolSize={},minPoolSize={}",
                initialPoolSize,maxPoolSize,minPoolSize);
        return dataSource;
    }

    @Bean(name = "fromSqlSessionFactory")
    @Primary
    public SqlSessionFactory fromSqlSessionFactory(@Qualifier("configDayDataSource") DataSource masterDataSource) throws Exception {

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(AcmDayDataSourceConfig.MAPPER_XML));
        return sessionFactory.getObject();
    }

    /**
     * 事物管理器.
     * @return
     * @throws PropertyVetoException
     */
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(acmDayDataSourceConfig());
    }

    @Bean(name = "dayJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("configDayDataSource") DataSource masterDataSource) {
        return new JdbcTemplate(masterDataSource);
    }
}
