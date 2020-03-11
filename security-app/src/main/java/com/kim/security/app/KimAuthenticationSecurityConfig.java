package com.kim.security.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @auther: kim
 * @create: 2019-09-30 11:26
 * @description:
 */
@Configuration
@EnableAuthorizationServer//开启spring实现的 OAuth协议
public class KimAuthenticationSecurityConfig {
}
