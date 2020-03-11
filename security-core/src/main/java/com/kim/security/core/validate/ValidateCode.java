package com.kim.security.core.validate;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @auther: kim
 * @create: 2019-09-27 12:11
 * @description:
 */
public class ValidateCode implements Serializable {

    private String code;
    private LocalDateTime expirTime;

    public ValidateCode(String code, LocalDateTime expirTime) {
        this.code = code;
        this.expirTime = expirTime;
    }

    public ValidateCode(String code, int expirTime) {
        this.code = code;
        this.expirTime = LocalDateTime.now().plusSeconds(expirTime);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isBefore(expirTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpirTime() {
        return expirTime;
    }

    public void setExpirTime(LocalDateTime expirTime) {
        this.expirTime = expirTime;
    }
}
