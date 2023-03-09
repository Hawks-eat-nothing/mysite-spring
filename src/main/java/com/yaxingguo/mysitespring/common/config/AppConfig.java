package com.yaxingguo.mysitespring.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Gson gson(){
        return new GsonBuilder().create();
    }
}
