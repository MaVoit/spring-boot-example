package com.voit.example.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author mark voit
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.voit.example.jpa"})
@EntityScan(basePackages = {"com.voit.example.model"})
public class DatabaseConfig {

    /**
     * Run simple controller based database client at http://localhost:8082/
     *
     * @return
     */
//    @Bean(initMethod = "start", destroyMethod = "shutdown")
//    @DependsOn("dataSource")
//    public Server dataSourceWebConnector() {
//        try {
//            return Server.createWebServer();
//        } catch (SQLException sqlException) {
//            throw new RuntimeException(sqlException);
//        }
//    }

}
