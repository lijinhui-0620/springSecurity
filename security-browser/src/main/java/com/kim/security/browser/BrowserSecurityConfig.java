package com.kim.security.browser;

import com.kim.security.core.config.SmsCodeAuthecticationSecurityConfig;
import com.kim.security.core.properties.SecurityProperties;
import com.kim.security.core.config.ImageCodeAuthecticationSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * @auther: kim
 * @create: 2019-09-24 13:08
 * @description:
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurity {

    @Autowired
    private SecurityProperties securityProperties;


    @Autowired
    private SmsCodeAuthecticationSecurityConfig smsCodeAuthecticationSecurityConfig;

    @Autowired
    private ImageCodeAuthecticationSecurityConfig imageCodeAuthecticationSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        applyPasswordAuthenticationConfig(http);
        http
                .apply(smsCodeAuthecticationSecurityConfig)
                    .and()
                .apply(imageCodeAuthecticationSecurityConfig)
                    .and()

                .authorizeRequests()
                 .antMatchers(securityProperties.getBrowserProperties().getLoginPage()).permitAll()
                    .antMatchers("/authentication/require").permitAll()
                    .antMatchers("/code/*").permitAll()
                    .antMatchers("/user/**").permitAll()
                    .antMatchers("/user").permitAll()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .csrf().disable()
        ;
    }
}
