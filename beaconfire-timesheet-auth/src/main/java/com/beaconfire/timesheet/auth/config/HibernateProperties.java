package com.beaconfire.timesheet.auth.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Getter
@Setter
@Configuration
@PropertySource("classpath:application.properties")
public class HibernateProperties {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${database.hibernate.dialect}")
    private String dialect;
    @Value("${database.hibernate.showsql}")
    private String showSql;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;
}
