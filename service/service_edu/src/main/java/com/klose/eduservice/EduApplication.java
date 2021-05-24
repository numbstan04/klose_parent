package com.klose.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Klose
 * @create 2021-05-23-20:46
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.klose"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
