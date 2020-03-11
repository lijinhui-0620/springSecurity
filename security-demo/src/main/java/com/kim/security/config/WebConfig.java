package com.kim.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @auther: kim
 * @create: 2019-09-24 11:08
 * @description:
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Bean
    public MutiCharacterEncodingFilter mutiCharacterEncodingFilter(){
        return new MutiCharacterEncodingFilter();
    }

}
