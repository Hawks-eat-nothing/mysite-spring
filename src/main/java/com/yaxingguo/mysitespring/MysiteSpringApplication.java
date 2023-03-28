package com.yaxingguo.mysitespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MysiteSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysiteSpringApplication.class, args);
    }

}
