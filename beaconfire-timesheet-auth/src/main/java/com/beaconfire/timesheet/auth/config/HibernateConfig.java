package com.beaconfire.timesheet.auth.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    private HibernateProperties hibernateProperties;

    @Autowired
    public void setHibernateProperties(HibernateProperties hibernateProperties){
        this.hibernateProperties = hibernateProperties;
    }

    @Bean
    protected LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.beaconfire.timesheet.auth.dao");
        sessionFactory.setHibernateProperties(hibernateProperty());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(hibernateProperties.getDriver());
        dataSource.setUrl(hibernateProperties.getUrl());
        dataSource.setUsername(hibernateProperties.getUsername());
        dataSource.setPassword(hibernateProperties.getPassword());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperty(){
        Properties hibernateProperty = new Properties();
        hibernateProperty.setProperty("hibernate.show_sql",hibernateProperties.getShowSql());
        hibernateProperty.setProperty("hibernate.dialect", hibernateProperties.getDialect());
//        hibernateProperty.setProperty("hibernate.ddl-auto",hibernateProperties.getDdl());
        return hibernateProperty;
    }
}
