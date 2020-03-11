package com.kim.security.browser;

import com.kim.security.browser.authentication.MyAuthecticationFailHandler;
import com.kim.security.browser.authentication.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @auther: kim
 * @create: 2019-09-27 13:22
 * @description:
 */
public class AbstractChannelSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    protected MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    protected MyAuthecticationFailHandler myAuthecticationFailHandler;

    @EventListener
    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/authentication/require").loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthecticationFailHandler);
    }
}
