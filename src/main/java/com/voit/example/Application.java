package com.voit.example;

import com.voit.example.config.AppConfig;
import org.springframework.boot.SpringApplication;

/**
 * @author mark voit
 */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}