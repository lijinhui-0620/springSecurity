package com.kim.security.core.config;

import com.kim.security.core.authecnicaion.mobile.SmsCodeAuthenticationFilter;
import com.kim.security.core.authecnicaion.mobile.SmsCodeAuthenticationProvider;
import com.kim.security.core.properties.SecurityProperties;
import com.kim.security.core.validate.sms.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @auther: kim
 * @create: 2019-09-27 12:55
 * @description: 短信验证码相关配置
 */
@Configuration
public class SmsCodeAuthecticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler myAuthecticationFailHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
        smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        smsCodeAuthenticationFilter.setAuthenticationFailureHandler(myAuthecticationFailHandler);
        smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);


        SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
        smsCodeAuthenticationProvider.setUserDetailsService(userDetailsService);

        SmsCodeFilter validateCodeFilter = new SmsCodeFilter();
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.setAuthenticationFailureHandler(myAuthecticationFailHandler);
        validateCodeFilter.afterPropertiesSet();

        http.authenticationProvider(smsCodeAuthenticationProvider)
                .addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validateCodeFilter, SmsCodeAuthenticationFilter.class);


    }
}
