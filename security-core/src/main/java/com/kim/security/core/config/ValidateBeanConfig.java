package com.kim.security.core.config;

import com.kim.security.core.properties.SecurityProperties;
import com.kim.security.core.validate.ValidateCodeGenerator;
import com.kim.security.core.validate.image.ImageCodeGenerator;
import com.kim.security.core.validate.sms.DefaultSmsCodeSender;
import com.kim.security.core.validate.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @auther: kim
 * @create: 2019-09-27 11:34
 * @description:
 */
@Configuration
public class ValidateBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator imageCodeGenertor = new ImageCodeGenerator();
        imageCodeGenertor.setSecurityProperties(securityProperties);
        return imageCodeGenertor;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        SmsCodeSender smsCodeSender = new DefaultSmsCodeSender();
        return smsCodeSender;
    }

    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
