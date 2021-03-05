package com.test.poemtree4.poem;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PoemConfig {


    @Bean
    public PoemRepository poemRepository(){
        return new PoemRepositoryImpl(getDataSource());
    }


    // DataSource Bean
    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sa");
        dataSourceBuilder.url("jdbc:h2:~/Desktop/dev/poemtree4");
        dataSourceBuilder.driverClassName("org.h2.Driver");

        return dataSourceBuilder.build();

    }

}
