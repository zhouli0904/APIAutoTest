package com.course.config;

import com.course.utils.ConfigFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public ConfigFile getUserMapper(){
        return new ConfigFile();
    }
}
