package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommunityConfig {
    @Bean("sendclass")
    public   String SendClass(){
        return  new String();
    }
}
