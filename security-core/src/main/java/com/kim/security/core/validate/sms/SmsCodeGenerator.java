package com.kim.security.core.validate.sms;

import com.kim.security.core.properties.SecurityProperties;
import com.kim.security.core.properties.SmsCodeProperties;
import com.kim.security.core.validate.ValidateCodeGenerator;
import com.kim.security.core.validate.image.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @auther: kim
 * @create: 2019-09-27 11:33
 * @description:
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public SmsCode generate(ServletWebRequest request) {
        System.out.println("生成短信验证码");
        SmsCodeProperties sms = securityProperties.getCode().getSms();

        SmsCode smsCode = new SmsCode("1234", sms.getExpireIn());
        return smsCode;
    }
}
