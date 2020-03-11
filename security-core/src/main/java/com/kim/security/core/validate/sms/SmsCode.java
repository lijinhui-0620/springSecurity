package com.kim.security.core.validate.sms;

import com.kim.security.core.validate.ValidateCode;

import java.time.LocalDateTime;

/**
 * @auther: kim
 * @create: 2019-09-27 12:12
 * @description:
 */
public class SmsCode extends ValidateCode {

    public SmsCode(String code, LocalDateTime expirTime) {
        super(code, expirTime);
    }

    public SmsCode(String code, int expirTime) {
        super(code, expirTime);
    }
}
