package com.sda.project.wypozyczalnia.config;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/wypozyczalnia?serverTimezone=Europe/Warsaw");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("karetson123");
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        return dataSourceBuilder.build();

    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }


}
