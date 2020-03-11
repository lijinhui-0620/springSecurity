package com.kim.security.app.authentication;

import com.kim.security.core.config.ImageCodeAuthecticationSecurityConfig;
import com.kim.security.core.config.SmsCodeAuthecticationSecurityConfig;
import com.kim.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @auther: kim
 * @create: 2019-09-30 12:25
 * @description:
 */
@EnableResourceServer
@Configuration
public class KimResourceSecurityConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;


    @Autowired
    private SmsCodeAuthecticationSecurityConfig smsCodeAuthecticationSecurityConfig;

    @Autowired
    private ImageCodeAuthecticationSecurityConfig imageCodeAuthecticationSecurityConfig;

    @Autowired
    protected MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    protected MyAuthecticationFailHandler myAuthecticationFailHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/authentication/require").loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthecticationFailHandler);

        http.apply(smsCodeAuthecticationSecurityConfig)
                .and()
                .apply(imageCodeAuthecticationSecurityConfig)
                .and()

                .authorizeRequests()
                .antMatchers(securityProperties.getBrowserProperties().getLoginPage()).permitAll()
                .antMatchers("/authentication/require").permitAll()
                .antMatchers("/code/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
