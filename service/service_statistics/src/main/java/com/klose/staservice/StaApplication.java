package com.klose.staservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Klose
 * @create 2021-07-18-15:07
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.klose"})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.klose.staservice.mapper")
@EnableScheduling
public class StaApplication {
        public static void main(String[] args) {
            SpringApplication.run(StaApplication.class, args);
        }
}
