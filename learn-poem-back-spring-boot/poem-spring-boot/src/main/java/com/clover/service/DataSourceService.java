package com.clover.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class DataSourceService{
    @Autowired
    private DataSource dataSource;
        public DataSourceService(DataSource dataSource) {
            this.dataSource = dataSource;
        }
            public void getcurrentDatasource(){
                if(dataSource instanceof DruidDataSource){
                    DruidDataSource druidDataSource = (DruidDataSource) dataSource;
                    System.out.println("当前使用的数据源是:"+ druidDataSource.getUrl());
                }else {
                    System.out.println("当前使用的数据源不是druid");
                }
            }
}