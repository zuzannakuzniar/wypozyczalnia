package com.sda.project.wypozyczalnia.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/wypozyczalnia?serverTimezone=Europe/Warsaw");
        dataSourceBuilder.username("root");
<<<<<<< HEAD
        dataSourceBuilder.password("Hakunamatata1");
=======
        dataSourceBuilder.password("karetson123");
>>>>>>> f859c041a6b2f1a1f0add225335d10d5179b5e02
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        return dataSourceBuilder.build();

    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }


}
