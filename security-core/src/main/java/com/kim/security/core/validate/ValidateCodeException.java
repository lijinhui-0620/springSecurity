package com.kim.security.core.validate;


import org.springframework.security.core.AuthenticationException;

/**
 * @auther: kim
 * @create: 2019-09-27 11:15
 * @description:
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
