package com.springjdbc;

import com.springjdbc.dao.impl;
import com.springjdbc.dao.studentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.springjdbc.dao"})
public class JDBCconfig {

    @Bean(name={"ds"})
    public DataSource getDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("12345");
        return ds;
    }

    @Bean(name={"jdbcTemplate"})
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean(name={"studentDao"})
    public studentDao getDao(){
        impl st=new impl();
        st.setJdbcTemplate(getTemplate());
        return st;
    }

}
