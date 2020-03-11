package com.kim.security.core.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @auther: kim
 * @create: 2019-09-27 11:55
 * @description: 验证器处理器
 */
public interface ValidateCodeProecssor {

    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * @Description: 创建校验码 共三步
     * 1.创建验证码
     * 2.保存验证码
     * 3.发送验证码
     * @Param: [request]
     * @return: void
     * @Author: kim
     * @Date: 2019/9/27
     */
    void create(ServletWebRequest request) throws Exception;
}
