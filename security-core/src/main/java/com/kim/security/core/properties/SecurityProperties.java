package com.kim.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther: kim
 * @create: 2019-09-25 12:19
 * @description:
 */
@ConfigurationProperties(prefix = "kkk.security")
public class SecurityProperties {

    private BrowserProperties browserProperties = new BrowserProperties();

    private ValidateCodeProperties code =new ValidateCodeProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }
}
