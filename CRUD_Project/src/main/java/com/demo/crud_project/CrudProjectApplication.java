package com.demo.crud_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class CrudProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudProjectApplication.class, args);
    }

}
