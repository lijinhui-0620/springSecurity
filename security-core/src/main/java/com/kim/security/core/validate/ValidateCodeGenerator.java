package com.kim.security.core.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @auther: kim
 * @create: 2019-09-27 11:33
 * @description: 验证码生成器
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
