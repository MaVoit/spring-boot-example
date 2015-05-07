package com.voit.example;

import com.voit.example.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author mark voit
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
    }
}