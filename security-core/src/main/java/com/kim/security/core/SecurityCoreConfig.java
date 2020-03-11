package com.kim.security.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kim.security.core.error.ErrorView;
import com.kim.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.View;


/**
 * @auther: kim
 * @create: 2019-09-25 12:22
 * @description:
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

    @Value("{error.view.path:error.html}")
    private String errViewPath;

    @Bean
    public View error(ObjectMapper objectMapper) {
        ErrorView errorView = new ErrorView(new ClassPathResource(errViewPath));
        errorView.setObjectMapper(objectMapper);
        return errorView;
    }
}
