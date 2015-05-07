package com.voit.example.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mark voit
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.voit.example")
public class AppConfig {

}
