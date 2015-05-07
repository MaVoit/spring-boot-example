package com.voit.example.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author mark voit
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.voit.example")
@Import(DatabaseConfig.class)
public class AppConfig {

}
