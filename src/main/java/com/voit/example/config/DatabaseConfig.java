package com.voit.example.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author mark voit
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.voit.example.repository"})
@EntityScan(basePackages = {"com.voit.example.entity"})
public class DatabaseConfig {

}
