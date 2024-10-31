package com.javaee.annotaion;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

//任务1.1：完成此类的编写
//<context:component-scan base-package="com.javaee.annotaion.dao.Impl,com.javaee.annotaion.service.Impl"/>
//<context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource(value = "classpath:jdbc.properties")
@ComponentScan(basePackages = {"com.javaee.annotaion.dao.Impl",
                               "com.javaee.annotaion.service.Impl"})
@Configuration
public class SpringConfig {

    @Bean
    public DruidDataSource druidDataSource(@Value("${mysql.url}") String url,
                                           @Value("${mysql.driverClassName}")String driverClassName,
                                           @Value("${mysql.username}")String username,
                                           @Value("${mysql.password}")String password){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }

}
