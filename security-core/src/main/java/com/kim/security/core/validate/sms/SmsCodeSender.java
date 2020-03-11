package com.kim.security.core.validate.sms;

/**
 * @auther: kim
 * @create: 2019-09-27 11:46
 * @description:
 */
public interface SmsCodeSender {
    void sender(String mobile, String code);
}
