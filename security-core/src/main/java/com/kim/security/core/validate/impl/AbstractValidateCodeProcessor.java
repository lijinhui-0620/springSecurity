package com.kim.security.core.validate.impl;

import com.kim.security.core.validate.ValidateCode;
import com.kim.security.core.validate.ValidateCodeGenerator;
import com.kim.security.core.validate.ValidateCodeProecssor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @auther: kim
 * @create: 2019-09-27 11:57
 * @description:
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProecssor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * @Description: 收集系统中所有的{@link ValidateCodeGenerator} 接口的实现
     * @Param:
     * @return:
     * @Author: kim
     * @Date: 2019/9/27
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    protected void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX + getProcessorType(request).toUpperCase(), validateCode);
    }

    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

    protected C generate(ServletWebRequest request) {
        String type = getProcessorType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
        return (C) validateCodeGenerator.generate(request);
    }

    protected String getProcessorType(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
    }
}
