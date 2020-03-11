package com.kim.security.core.validate.sms;

/**
 * @auther: kim
 * @create: 2019-09-27 11:47
 * @description:
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void sender(String mobile, String code) {
        System.out.println("向手机发送验证码，手机号：" + mobile + ",验证码：" + code);
    }
}
