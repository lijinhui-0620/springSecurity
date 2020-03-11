package com.kim.security.core.config;

import com.kim.security.core.properties.SecurityProperties;
import com.kim.security.core.validate.image.ImageCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @auther: kim
 * @create: 2019-09-27 12:55
 * @description: 图片验证码相关配置
 */
@Configuration
public class ImageCodeAuthecticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {


    @Autowired
    private AuthenticationFailureHandler myAuthecticationFailHandler;


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ImageCodeFilter imageCodeFilter = new ImageCodeFilter();
        imageCodeFilter.setSecurityProperties(securityProperties);
        imageCodeFilter.setAuthenticationFailureHandler(myAuthecticationFailHandler);
        imageCodeFilter.afterPropertiesSet();
        http
                .addFilterAfter(imageCodeFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
